import java.util.ArrayList;

/**
 * Created by piscary on 13.02.17.
 */
public class Square {

    public int posX;
    public int posY;
    public int group;
    public int cipher;
    public ArrayList<Integer> possibilities = new ArrayList<>();
    public ArrayList<Square> peers = new ArrayList<>();
    public boolean locked = false;

    public Square(int posX, int posY, int number, int cipher) {
        this.posX = posX;
        this.posY = posY;
        this.group = findGroup(number);
        this.cipher = cipher;
        if (this.cipher == 0) {
            this.possibilities.add(1);
            this.possibilities.add(2);
            this.possibilities.add(3);
            this.possibilities.add(4);
            this.possibilities.add(5);
            this.possibilities.add(6);
            this.possibilities.add(7);
            this.possibilities.add(8);
            this.possibilities.add(9);
        } else {
            this.possibilities.add(this.cipher);
            this.locked = true;
        }
    }

    public int findGroup(int number) {
        ArrayList<int[]> groups = new ArrayList<>();
        int grp1[] = {0, 1, 2, 9, 10, 11, 18, 19, 20};
        groups.add(grp1);
        int grp2[] = {3, 4, 5, 12, 13, 14, 21, 22, 23};
        groups.add(grp2);
        int grp3[] = {6, 7, 8, 15, 16, 17, 24, 25, 26};
        groups.add(grp3);
        int grp4[] = {27, 28, 29, 36, 37, 38, 45, 46, 47};
        groups.add(grp4);
        int grp5[] = {30, 31, 32, 39, 40, 41, 48, 49, 50};
        groups.add(grp5);
        int grp6[] = {33, 34, 35, 42, 43, 44, 51, 52, 53};
        groups.add(grp6);
        int grp7[] = {54, 55, 56, 63, 64, 65, 72, 73, 74};
        groups.add(grp7);
        int grp8[] = {57, 58, 59, 66, 67, 68, 75, 76, 77};
        groups.add(grp8);
        int grp9[] = {60, 61, 62, 69, 70, 71, 78, 79, 80};
        groups.add(grp9);

        for (int[] grp : groups) {
            for (int i = 0; i < grp.length; i++) {
                if (grp[i] == number) {
                    return i + 1;
                }
            }
        }
        return 0;
    }

    public void findPeers(ArrayList<Square> squares) {
        ArrayList<Square> peers = new ArrayList<>();
        for (Square s : squares) {
            if (this.group == s.group && this.posX != s.posX && this.posY != s.posY) {
                peers.add(s);
            } else if (this.posX == s.posX && this.posY != s.posY) {
                peers.add(s);
            } else if (this.posX != s.posX && this.posY == s.posY) {
                peers.add(s);
            }
        }
        this.peers = peers;
    }

    public void updatePossibilities() {
        if (!this.locked) {
            for (Square p : this.peers) {
                this.possibilities.remove(new Integer(p.cipher));
                if (this.possibilities.size() == 1) {
                    this.cipher = this.possibilities.get(0);
                    this.locked = true;
                }
            }
            /*boolean onlyGroup = true;
            boolean onlyLine = true;
            boolean onlyRow = true;
            Integer currentPoss = 0;
            for(Integer possA: this.possibilities){
                currentPoss = possA;
                for(Square p: this.peers){
                    for(Integer possB: p.possibilities){
                        if(possA == possB && this.group == p.group){
                            onlyGroup = false;
                        }
                        if(possA == possB && this.posX == p.posX){
                            onlyLine = false;
                        }
                        if(possA == possB && this.posY == p.posY){
                            onlyRow = false;
                        }
                    }
                }
            }
            boolean only = onlyGroup || onlyLine || onlyRow;
            if(only && currentPoss!=0){
                this.cipher = currentPoss;
                this.locked = true;
            }*/
        }
    }

    public String toString() {
        return ("[" + this.posX + ":" + this.posY + "]");
    }
}
