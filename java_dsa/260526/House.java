public class House{
    public static int findpath(int startrow, int startcol, int endrow, int endcol, boolean[][] visited){
        if(startrow == endrow && startcol == endcol){
            return 1;
        }
        if(startrow < 0 || startcol < 0 || startrow > endrow || startcol > endcol || visited[startrow][startcol]){
            return 0;
        }
        visited[startrow][startcol] = true;
        int right = findpath(startrow, startcol + 1, endrow, endcol, visited);
        int down = findpath(startrow + 1, startcol, endrow, endcol, visited);
        int left = findpath(startrow, startcol - 1, endrow, endcol, visited);
        int up = findpath(startrow - 1, startcol, endrow, endcol, visited);
        visited[startrow][startcol] = false;
        return right+left+down+up;
    }
    public static void findpaths(int startrow, int startcol, int endrow, int endcol, String path, boolean[][] visited){
        if(startrow == endrow && startcol == endcol){
            System.out.println(path);
            return;
        }
        if(startrow < 0 || startcol < 0 || startrow > endrow || startcol > endcol || visited[startrow][startcol]){
            return;
        }
        visited[startrow][startcol] = true;
        findpaths(startrow, startcol + 1, endrow, endcol, path + "R", visited);
        findpaths(startrow + 1, startcol, endrow, endcol, path + "D", visited);
        findpaths(startrow, startcol - 1, endrow, endcol, path + "L", visited);
        findpaths(startrow - 1, startcol, endrow, endcol, path + "U", visited);
        visited[startrow][startcol] = false;
    }
    public static void main(String[] args) {
        boolean[][] visited = new boolean[3][3];
        System.out.println(findpath(0, 0, 2, 2, visited));
        // findpaths(0, 0, 2, 2, "", visited);
    }


}