class Consumidor extends Thread {
    public BufferCircular b;
    private int x;
    
    public Consumidor (BufferCircular b,String c){
         this.b=b;
         this.setName(c);
    }
    public void run() {
        do {
            x = b.get();
            System.out.println(this.getName()+": Extraido el valor "+x); 
        } while (x >= 0);
        System.out.println("Fin del consumidor "+ this.getName());
    }
}
