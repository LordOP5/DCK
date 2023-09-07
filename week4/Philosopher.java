import java.util.*;

public class Philosopher extends Thread {
    Fork left, right; // อ้างอิงถึง object ของส้อมด้านซ้ายและด้านขวาของ Philosopher
    String name; // ชื่อของ Philosopher
    String status = "---"; // สถานะของ Philosopher
    int numEat = 0;
    boolean done = false;
    Random r = new Random();

    public Philosopher(String name, Fork left, Fork right) { // รับชื่อ Philosopher และ object ของส้อมซ้าย-ขวา
        this.left = left;
        this.right = right;
        this.name = name;
    }

    public String getStatus() {
        return status; // เรียกเพื่อคืนค่าสถานะของ Philosopher
    }

    public int getNumEat() {
        return numEat; // เรียกเพื่อคืนค่าจำนวนครั้งที่ Philosopher ได้กินอาหาร
    }

    public void done() {
        done = true; // เรียกเพื่อหยุดการทำงานของ Philosopher
    }

    public void think() { // เรียกเพื่อให้ Philosopher อยู่ในสถานะคิด (THK)
        status = "THK"; 
        try {
            Thread.sleep(r.nextInt(150) + 150);
        } catch(Exception e) {}
    }

    public void eat() { // เรียกเพื่อให้ Philosopher อยู่ในสถานะกิน (EAT)
        status = "EAT"; 
        try {
            Thread.sleep(r.nextInt(150) + 150);
        } catch(Exception e) {}
    }

    // Philosopher จะเริ่มต้นที่คิด เมื่อคิดเสร็จจะหยิบส้อม เมื่อได้ส้อม 2 อันถึงจะสามารถกินได้ เมื่อกินสำเร็จให้เพิ่มค่า numEat

    public void run(){
        while(!done) {
            think();
            if(left.take(name)) {
                if(right.take(name)) {
                    eat();
                    numEat++;
                    right.putDown();
                }
                left.putDown();
            }
        }
    }
}