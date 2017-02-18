package com.github.Piscary;

import java.util.ArrayList;

/**
 * Created by piscary on 13.02.17.
 */
public class Square {

    private int posX;
    private int posY;
    private int group;
    private int cipher;
    private ArrayList<Integer> possibilities;
    private ArrayList<Square> peers;
    private boolean locked = false;

    public Square(int posX, int posY, int number, int cipher) {
        this.posX = posX;
        this.posY = posY;
        this.group = findGroup(number);
        this.cipher = cipher;
        if (this.cipher == 0) {
            addOneToNinePossibilities();
        } else {
            final ArrayList<Integer> tmpPossibilities = new ArrayList<>();
            tmpPossibilities.add(this.cipher);
            setPossibilities(tmpPossibilities);
            this.locked = true;
        }
    }

    private void addOneToNinePossibilities() {
        final ArrayList<Integer> tmpPossibilities = new ArrayList<>();
        for (int i=1; i <= 9; i++) {
            tmpPossibilities.add(i);
        }
        setPossibilities(tmpPossibilities);
    }

    private static int findGroup(int number) {
        switch (number) {
            case 0: case 1: case 2: case 9: case 10: case 11: case 18: case 19: case 20:
                return 1;
            case 3: case 4: case 5: case 12: case 13: case 14: case 21: case 22:case 23:
                return 2;
            case 6: case 7: case 8: case 15: case 16: case 17: case 24: case 25:case 26:
                return 3;
            case 27: case 28: case 29: case 36: case 37: case 38: case 45: case 46: case 47:
                return 4;
            case 30: case 31: case 32: case 39: case 40: case 41: case 48: case 49: case 50:
                return 5;
            case 33: case 34: case 35: case 42: case 43: case 44: case 51: case 52: case 53:
                return 6;
            case 54: case 55: case 56: case 63: case 64: case 65: case 72: case 73: case 74:
                return 7;
            case 57: case 58: case 59: case 66: case 67: case 68: case 75: case 76: case 77:
                return 8;
            case 60: case 61: case 62: case 69: case 70: case 71: case 78: case 79: case 80:
               return 9;
            default:
                return -1;
        }
    }

    public static void findPeers(final Square source ,final ArrayList<Square> squares) {
        final ArrayList<Square> peers = new ArrayList<>();
        for (final Square square : squares) {
            if (source.getGroup() == square.getGroup() && source.getPosX() != square.getPosX() && source.getPosY() != square.getPosY()) {
                peers.add(square);
            } else if (source.getPosX() == square.getPosX() && source.getPosY() != square.getPosY()) {
                peers.add(square);
            } else if (source.getPosX() != square.getPosX() && source.getPosY() == square.getPosY()) {
                peers.add(square);
            }
        }
        source.peers = peers;
    }

    public void updatePossibilities() {
        if ( locked ) {
            for (Square peer : getPeers()) {
                possibilities.remove(Integer.valueOf(peer.getCipher()));
                if (getPossibilities().size() == 1) {
                    cipher = getPossibilities().get(0);
                    locked = true;
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

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getCipher() {
        return cipher;
    }

    public void setCipher(int cipher) {
        this.cipher = cipher;
    }

    public ArrayList<Integer> getPossibilities() {
        return possibilities;
    }

    public void setPossibilities(ArrayList<Integer> possibilities) {
        this.possibilities = possibilities;
    }

    public ArrayList<Square> getPeers() {
        return peers;
    }

    public void setPeers(ArrayList<Square> peers) {
        this.peers = peers;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String toString() {
        return ("[" + this.posX + ":" + this.posY + "]");
    }
}
