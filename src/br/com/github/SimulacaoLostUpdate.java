package br.com.github;

public class SimulacaoLostUpdate {

    public static void main(String[] args) throws InterruptedException {
        Account acc = new Account(0);
        Thread tA = new Thread(() -> acc.rawDeposit(70));
        Thread tB = new Thread(() -> acc.rawDeposit(50));
        tA.start();
        tB.start();
        tA.join();
        tB.join();

        System.out.println(acc.getRawBalance());
    }
}
