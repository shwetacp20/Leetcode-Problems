import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int start = -1;
        ArrayList<Integer> litter = new ArrayList<>();

        // Find S and all L cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);

                if (c == 'S') {
                    start = i * n + j;
                } else if (c == 'L') {
                    litter.add(i * n + j);
                }
            }
        }

        int k = litter.size();

        // No litter to collect
        if (k == 0) {
            return 0;
        }

        // Map litter cell -> bit number
        int[] litterId = new int[m * n];
        Arrays.fill(litterId, -1);

        for (int i = 0; i < k; i++) {
            litterId[litter.get(i)] = i;
        }

        int fullMask = (1 << k) - 1;

        /*
         * State:
         * position
         * collected litter mask
         * remaining energy
         *
         * BFS guarantees the first time we reach fullMask
         * is the minimum number of moves.
         */

        boolean[][][] visited =
                new boolean[m * n][1 << k][energy + 1];

        Queue<State> queue = new ArrayDeque<>();

        queue.offer(new State(start, 0, energy));
        visited[start][0][energy] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {
                State cur = queue.poll();

                int pos = cur.pos;
                int mask = cur.mask;
                int e = cur.energy;

                if (mask == fullMask) {
                    return moves;
                }

                int r = pos / n;
                int c = pos % n;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= m ||
                        nc < 0 || nc >= n) {
                        continue;
                    }

                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    // Cannot move if energy is already 0.
                    if (e == 0) {
                        continue;
                    }

                    int newPos = nr * n + nc;
                    int newEnergy = e - 1;
                    int newMask = mask;

                    // Collect litter
                    if (classroom[nr].charAt(nc) == 'L') {
                        int id = litterId[newPos];
                        newMask |= (1 << id);
                    }

                    // Reset energy
                    if (classroom[nr].charAt(nc) == 'R') {
                        newEnergy = energy;
                    }

                    if (!visited[newPos][newMask][newEnergy]) {
                        visited[newPos][newMask][newEnergy] = true;
                        queue.offer(
                            new State(newPos, newMask, newEnergy)
                        );
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    static class State {
        int pos;
        int mask;
        int energy;

        State(int pos, int mask, int energy) {
            this.pos = pos;
            this.mask = mask;
            this.energy = energy;
        }
    }
}