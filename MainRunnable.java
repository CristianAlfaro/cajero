public class MainRunnable implements  Runnable{

        private Cliente cliente;
        private Cajero Cajero;
        private long initialTime;

        public MainRunnable(Cliente cliente, Cajero Cajero, long initialTime){
            this.Cajero = Cajero;
            this.cliente = cliente;
            this.initialTime = initialTime;
        }

        public static void main(String[] args) {

            Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
            Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });

            Cajero Cajero1 = new Cajero("Cajero 1");
            Cajero Cajero2 = new Cajero("Cajero 2");

            // Tiempo inicial de referencia
            long initialTime = System.currentTimeMillis();

            Runnable proceso1 = new MainRunnable(cliente1, Cajero1, initialTime);
            Runnable proceso2 = new MainRunnable(cliente2, Cajero2, initialTime);

            new Thread(proceso1).start();
            new Thread(proceso2).start();

        }

        @Override
        public void run() {
            this.Cajero.procesarCompra(this.cliente, this.initialTime);
        }

}
