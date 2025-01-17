import java.util.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int R, C;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();
        map = new char[R][C];
        Queue<Point> water = new LinkedList<>();
        Point start = null;
        Point dest = null;

        for (int i = 0; i < R; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == '*') {
                    water.offer(new Point(i, j));
                } else if (map[i][j] == 'S') {
                    start = new Point(i, j);
                } else if (map[i][j] == 'D') {
                    dest = new Point(i, j);
                }
            }
        }

        int result = bfs(start, dest, water);
        System.out.println(result == -1 ? "KAKTUS" : result);
        sc.close();
    }

    static int bfs(Point start, Point dest, Queue<Point> water) {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        int time = 0;
        boolean[][] visited = new boolean[R][C];
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            int waterSize = water.size();
            for (int i = 0; i < waterSize; i++) {
                Point curr = water.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = curr.x + dx[j];
                    int ny = curr.y + dy[j];
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        water.offer(new Point(nx, ny));
                    }
                }
            }

            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Point curr = q.poll();
                if (curr.x == dest.x && curr.y == dest.y) {
                    return time;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = curr.x + dx[j];
                    int ny = curr.y + dy[j];
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny] && (map[nx][ny] == '.' || map[nx][ny] == 'D')) {
                        visited[nx][ny] = true;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
            time++;
        }
        return -1;
    }
}