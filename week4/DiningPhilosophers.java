public class DiningPhilosophers {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Fork[] fork = new Fork[n]; // สร้าง Array สำหรับ Object ของส้อม n อัน
        Philosopher[] philosopher = new Philosopher[n]; // สร้าง Array Object ของ Philosopher n คน
        
        // ใส่ code ตรงนี้เพื่อสร้าง Object ของส้อม และ Philosopher ให้ชื่อของ Philosopher คือ P0, P1, ... ตามลำดับ 

        for (int i = 0; i < n; i++) { // สร้าง Object ของส้อม
            fork[i] = new Fork();
        }

        for (int i = 0; i < n; i++) { // สร้าง Object ชื่อของ Philosopher คือ P0, P1, ... ตามลำดับ
            philosopher[i] = new Philosopher("P" + i, fork[i], fork[(i + 1) % n]);
        }

        // เริ่มต้น Thread philosopher 

        for (int i = 0; i < n; i++) {
            philosopher[i].start();
        }

        // ส่วนแสดงผลทุกๆ 100 ms เป็นจำนวน 100 ครั้งก่อนให้จบโปรแกรม

        String info;
        
        for(int i = 0; i < 100; i++) {
            info = "|";
            for(int j = 0; j < n; j++) {
                info += (philosopher[j].getStatus() + "|");
            }
            info += "\t\t|";
            for(int j = 0; j < n; j++) {
                info += (fork[j].getHolderName() + "|");
            }
            System.out.println(info);
            try {
                Thread.sleep(100);
            } catch(Exception e) {}
        }

        for(int i = 0; i < n; i++) {
            philosopher[i].done();
            System.out.println("P" + i + ": eat " + philosopher[i].getNumEat() + " times");
        }
    }   
}