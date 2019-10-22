package com.codecool.quest.logic;

import com.codecool.quest.logic.actors.Player;
import com.codecool.quest.logic.actors.Skeleton;
import com.codecool.quest.logic.items.Key;
import com.codecool.quest.logic.items.Sword;

import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {
    public static GameMap loadMap() {
        InputStream is = MapLoader.class.getResourceAsStream("/map2.txt");
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case 'b':
                            cell.setType(CellType.BRIDGE);
                            break;
                        case 't':
                            cell.setType(CellType.TARLOS);
                            break;
                        case 'o':
                            cell.setType(CellType.PARLIAMENT);
                            break;
                        case '1':
                            cell.setType(CellType.POLITICIAN1);
                            break;
                        case '2':
                            cell.setType(CellType.POLITICIAN2);
                            break;
                        case '=':
                            cell.setType(CellType.RIVER);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            Skeleton skeleton = new Skeleton(cell);
                            map.addActor(skeleton);
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            Player player = new Player(cell);
                            map.setPlayer(player);
                            map.addActor(player);
                            break;
                        case 'k':
                            cell.setType(CellType.FLOOR);
                            new Key(cell);
                            break;
                        case 'w':
                            cell.setType(CellType.FLOOR);
                            new Sword(cell);
                            break;
                        case 'p':
                            cell.setType(CellType.PINE);
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }

}
