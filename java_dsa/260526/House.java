public class House{
    public static int findpath(int startrow, int startcol, int endrow, int endcol){
        if(startrow == endrow && startcol == endcol){
            return 1;
        }
        if(startrow > endrow || startcol > endcol){
            return 0;
        }
        int right = findpath(startrow, startcol + 1, endrow, endcol);
        int down = findpath(startrow + 1, startcol, endrow, endcol);
        int left = findpath(startrow, startcol - 1, endrow, endcol);
        int up = findpath(startrow - 1, startcol, endrow, endcol);
        return right+left+down+up;
    }
    public static void findpaths(int startrow, int startcol, int endrow, int endcol, String path){
        if(startrow == endrow && startcol == endcol){
            System.out.println(path);
            return;
        }
        if(startrow > endrow || startcol > endcol){
            return;
        }
        findpaths(startrow, startcol + 1, endrow, endcol, path + "R");
        findpaths(startrow + 1, startcol, endrow, endcol, path + "D");
        findpaths(startrow, startcol - 1, endrow, endcol, path + "L");
        findpaths(startrow - 1, startcol, endrow, endcol, path + "U");
    }
    public static void main(String[] args) {
        System.out.println(findpath(0, 0, 2, 2));
        // findpaths(0, 0, 2, 2, "");
    }


}