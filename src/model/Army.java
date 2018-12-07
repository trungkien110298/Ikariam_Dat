package model;

import java.util.Stack;
import model.unit.Archer;
import model.unit.BalloonBombardier;
import model.unit.Catapult;
import model.unit.Gyrocopter;
import model.unit.Hoplite;
import model.unit.Mortar;
import model.unit.Ram;
import model.unit.Slinger;
import model.unit.Spearman;
import model.unit.SteamGiant;
import model.unit.SulphurCarabineer;
import model.unit.Swordsman;
import ui.IsLandUI;


/* 
 * Quy định cách đặt tên biến:
1. Các đơn vị quân: Tất cả các đơn vị quân sẽ có tên giống trong game, trừ Balloon Bombardier và Sulfur Carabineer
                    viết gọn lại thành Balloon và Sulfur.
                   
 */
public class Army {

    private int[] damageUpgrade = new int[12];
    private int[] armourUpgrade = new int[12];
    private Wall wall;
    
    private int numberOfHop;
    private int numberOfSteam;

    private int numberOfSword;
    private int numberOfSpear;

    private int numberOfBB;
    private int numberOfGyrocopter;

    private int numberOfRam;
    private int numberOfCatapult;
    private int numberOfMotar;

    private int numberOfSlinger;
    private int numberOfArcher;
    private int numberOfSC;

    public static enum Unit {
        Archer(2, ""), Balloon(1, ""), Catapult(2, ""), Gyrocopter(1, ""), Hoplite(1, ""), Mortar(1, ""), Ram(3, ""), Slinger(3, ""), Spearman(2, ""), SteamGiant(2, ""), Sulfur(1, ""), Swordsman(1, ""), Wall(0, "");
        private int priorityInLine;
        private String img;

        private Unit(int prio, String img) {
            this.priorityInLine = prio;
            this.img = img;
        }

        public int getPriorityInLine() {
            return priorityInLine;
        }

        public void setPriorityInLine(int priorityInLine) {
            this.priorityInLine = priorityInLine;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

    }
    
    public void clear(){
        numberOfArcher = 0;
        numberOfBB = 0;
        numberOfCatapult = 0;
        numberOfGyrocopter = 0;
        numberOfHop = 0;
        numberOfMotar = 0;
        numberOfRam = 0;
        numberOfSC = 0;
        numberOfSlinger = 0;
        numberOfSpear = 0;
        numberOfSteam = 0;
        numberOfSword = 0;
    }

    public static enum ClassUnit {
        Front, LRF, Artillery, Flank, Bomber, Airdefence;
    }

    



    public Army() {
        // TODO Auto-generated constructor stub
    }

    public int getNumberOfHop() {
        return numberOfHop;
    }
    public void setNumberOfHop(int numberOfHop) {
        this.numberOfHop = numberOfHop;
    }

    public int getNumberOfSteam() {
        return numberOfSteam;
    }

    public void setNumberOfSteam(int numberOfSteam) {
        this.numberOfSteam = numberOfSteam;
    }

    public int getNumberOfSword() {
        return numberOfSword;
    }

    public void setNumberOfSword(int numberOfSword) {
        this.numberOfSword = numberOfSword;
    }

    public int getNumberOfSpear() {
        return numberOfSpear;
    }

    public void setNumberOfSpear(int numberOfSpear) {
        this.numberOfSpear = numberOfSpear;
    }

    public int getNumberOfBB() {
        return numberOfBB;
    }

    public void setNumberOfBB(int numberOfBB) {
        this.numberOfBB = numberOfBB;
    }

    public int getNumberOfGyrocopter() {
        return numberOfGyrocopter;
    }

    public void setNumberOfGyrocopter(int numberOfGyrocopter) {
        this.numberOfGyrocopter = numberOfGyrocopter;
    }

    public int getNumberOfRam() {
        return numberOfRam;
    }

    public void setNumberOfRam(int numberOfRam) {
        this.numberOfRam = numberOfRam;
    }

    public int getNumberOfCatapult() {
        return numberOfCatapult;
    }

    public void setNumberOfCatapult(int numberOfCatapult) {
        this.numberOfCatapult = numberOfCatapult;
    }

    public int getNumberOfMotar() {
        return numberOfMotar;
    }

    public void setNumberOfMotar(int numberOfMotar) {
        this.numberOfMotar = numberOfMotar;
    }

    public int getNumberOfSlinger() {
        return numberOfSlinger;
    }

    public void setNumberOfSlinger(int numberOfSlinger) {
        this.numberOfSlinger = numberOfSlinger;
    }

    public int getNumberOfArcher() {
        return numberOfArcher;
    }

    public void setNumberOfArcher(int numberOfArcher) {
        this.numberOfArcher = numberOfArcher;
    }

    public int getNumberOfSC() {
        return numberOfSC;
    }

    public void setNumberOfSC(int numberOfSC) {
        this.numberOfSC = numberOfSC;
    }

    public Wall getWall() {
        return wall;
    }

    public void setWall(Wall wall) {
        this.wall = wall;
    }

    public int getNumberOf(Unit unit) {
        switch (unit) {
            case Archer:
                return getNumberOfArcher();
            case Balloon:
                return getNumberOfBB();
            case Catapult:
                return getNumberOfCatapult();
            case Gyrocopter:
                return getNumberOfGyrocopter();
            case Hoplite:
                return getNumberOfHop();
            case Mortar:
                return getNumberOfMotar();
            case Ram:
                return getNumberOfRam();
            case Slinger:
                return getNumberOfSlinger();
            case Spearman:
                return getNumberOfSpear();
            case SteamGiant:
                return getNumberOfSteam();
            case Sulfur:
                return getNumberOfSC();
            case Swordsman:
                return getNumberOfSword();
            default:
                return 0;
        }
    }

    public void setNumberOf(Unit unit, int number) {
        switch (unit) {
            case Archer:
                setNumberOfArcher(number);
                break;
            case Balloon:
                setNumberOfBB(number);
                break;
            case Catapult:
                setNumberOfCatapult(number);
                break;
            case Gyrocopter:
                setNumberOfGyrocopter(number);
                break;
            case Hoplite:
                setNumberOfHop(number);
                break;
            case Mortar:
                setNumberOfMotar(number);
                break;
            case Ram:
                setNumberOfRam(number);
                break;
            case Slinger:
                setNumberOfSlinger(number);
                break;
            case Spearman:
                setNumberOfSpear(number);
                break;
            case SteamGiant:
                setNumberOfSteam(number);
                break;
            case Sulfur:
                setNumberOfSC(number);
                break;
            case Swordsman:
                setNumberOfSword(number);
                break;
            default:

        }
    }

    public void addArmy(Army get) {
        this.numberOfArcher += get.numberOfArcher;
        this.numberOfBB += get.numberOfBB;
        this.numberOfCatapult += get.numberOfCatapult;
        this.numberOfGyrocopter += get.numberOfGyrocopter;
        this.numberOfHop += get.numberOfHop;
        this.numberOfMotar += get.numberOfMotar;
        this.numberOfRam += get.numberOfRam;
        this.numberOfSC += get.numberOfSC;
        this.numberOfSlinger += get.numberOfSlinger;
        this.numberOfSpear += get.numberOfSpear;
        this.numberOfSteam += get.numberOfSteam;
        this.numberOfSword += get.numberOfSword;
    }

    public String getImageOf(Army.Unit unit) {
        switch (unit) {
            case Archer:
                return "/image/ArcherBB.png";
            case Balloon:
                return "/image/Balloon-BombardierBB.png";
            case Catapult:
                return "/image/CatapultBB.png";
            case Gyrocopter:
                return "/image/GyrocopterBB.png";
            case Hoplite:
                return "/image/HopliteBB.png";
            case Mortar:
                return "/image/MortarBB.png";
            case Ram:
                return "/image/RamBB.png";
            case Slinger:
                return "/image/SlingerBB.png";
            case Spearman:
                return "/image/SpearmanBB.png";
            case SteamGiant:
                return "/image/SteamGiantBB.png";
            case Sulfur:
                return "/image/SulphurCarabineerBB.png";
            case Swordsman:
                return "/image/SwordsmanBB.png";
            default:
                return null;
        }
    }

    public int[] getDamageUpgrade() {
        return damageUpgrade;
    }

    public void setDamageUpgrade(int[] damageUpgrade) {
        this.damageUpgrade = damageUpgrade;
    }

    public int[] getArmourUpgrade() {
        return armourUpgrade;
    }

    public void setArmourUpgrade(int[] armourUpgrade) {
        this.armourUpgrade = armourUpgrade;
    }
    
    // Hàm tính thời gian
    public int getSpeedTimeForWholeRoute() {
        if (getNumberOfBB() > 0)
            return 30*60*1000/IsLandUI.timeSpeed;
        else if (getNumberOfSteam() 	> 0 
                || getNumberOfMotar() 	> 0 
                || getNumberOfCatapult()> 0 
                || getNumberOfRam() 	> 0)
            return 15*60*1000/IsLandUI.timeSpeed;
        else if (getNumberOfArcher() 	> 0 
                || getNumberOfSC() 		> 0 
                || getNumberOfSlinger() > 0
                || getNumberOfHop() 	> 0 
                || getNumberOfSpear() 	> 0
                || getNumberOfSword() > 0)
            return 10*60*1000/IsLandUI.timeSpeed;
        
        return 75*6*1000/IsLandUI.timeSpeed;    // chỉ có máy bay
    }
}
