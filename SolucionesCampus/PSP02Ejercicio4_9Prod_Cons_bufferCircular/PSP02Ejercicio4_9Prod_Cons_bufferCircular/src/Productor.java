 class Productor extends Thread {

    private int N;
    public BufferCircular b;    

    public Productor(BufferCircular b, int max, String c) {        
        this.b=b;
        N = max;
        this.setName(c);
    }

    public void run() {
        for (int i = 0; i < N; i++) {
            System.out.println(this.getName()+": Almacenado el valor "+i);
            b.put(i);            
        }
        b.put(-1);
        System.out.println("Fin del productor");
    }
}
