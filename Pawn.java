public class Pawn {
    private int row;
    private int column;

    enum moveDirections {
        LEFT, RIGHT
    };

    boolean isBrown;
    boolean isEaten;

    public Pawn(int row, int column, boolean isBrown, boolean isEaten) {
        this.row = row;
        this.column = column;
        this.isBrown = isBrown;
        this.isEaten = isEaten;

    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public int setRow(int row) {
        return this.row;
    }

    public int setColumn(int column) {
        return this.column;
    }

    public boolean equals(Object o) {
        if (o instanceof Pawn) {
            Pawn d = (Pawn) o;
            if (d.row == this.row && d.column == this.column) {
                return true;
            }
            return false;
        }
        return false;
    }

    public void move(moveDirections direction){
        if(this.isBrown){
            switch (direction) {
                case LEFT:{//DownLeft
                    for (int row = 1; row <9; row++) {
                        for (int column = 1; column < 9; column++) {
                            if(this.getRow()==8 && this.getRow()<9){
                                this.row--;
                                this.column--;
                                this.isBrown=true;
                            }
                            this.isBrown=true;
                            this.isEaten=true;
                        }
                    }
                    this.row++;
                    this.column--;
                    break;
                }
                case RIGHT:{//DownRight
                    for (int row = 1; row <9; row++) {
                        for (int column = 1; column < 9; column++) {
                            if(this.getRow()==8 && this.getRow()<9){
                                this.row--;
                                this.column++;
                                this.isBrown=true;
                            }
                            this.isBrown=true;
                            this.isEaten=true;
                        }
                    }
                    this.row++;
                    this.column++;
                    break;
                }
            }
        }else{
            switch (direction) {
                case LEFT:{//UpLeft
                    for (int row = 1; row <9; row++) {
                        for (int column = 1; column < 9; column++) {
                            if(this.getRow()==8 && this.getRow()<9){
                                this.row++;
                                this.column--;
                                this.isBrown=true;
                            }
                            this.isBrown=false;
                            this.isEaten=true;
                        }
                    }
                    this.row--;
                    this.column--;
                    break;
                }
                case RIGHT:{//UpRight
                    for (int row = 1; row <9; row++) {
                        for (int column = 1; column < 9; column++) {
                            if(this.getRow()==8 && this.getRow()<9){
                                this.row--;
                                this.column++;
                                this.isBrown=true;
                            }
                            this.isBrown=false;
                            this.isEaten=true;
                        }
                    }
                    this.row--;
                    this.column++;
                    break;
                }
            }
        }
    }
}