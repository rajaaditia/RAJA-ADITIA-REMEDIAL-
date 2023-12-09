import java.util.ArrayList;
import java.util.Scanner;

public class NilaiMahasiswa {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Nilai> listNilai = new ArrayList<>();

        // Membaca nama mahasiswa
        System.out.print("Masukkan nama mahasiswa: ");
        String nama = sc.nextLine();

        System.out.print("Masukkan semester: ");
        int semester = sc.nextInt();

        System.out.print("Masukkan jumlah mata kuliah: ");
        int jumlah = sc.nextInt();

        for (int i = 0; i < jumlah; i++) {

            Nilai nilai = new Nilai();

            System.out.print("Masukkan kode mata kuliah ke-" + (i+1) + ": ");
            nilai.setKode(sc.next());

            System.out.print("Masukkan nama mata kuliah ke-" + (i+1) + ": ");
            nilai.setMataKuliah(sc.next());

            System.out.print("Masukkan sks mata kuliah ke-" + (i+1) + ": ");
            nilai.setSks(sc.nextInt());

            System.out.print("Masukkan nilai mata kuliah ke-" + (i+1) + ": ");
            nilai.setNilai(sc.nextDouble());

            nilai.hitungHurufMutu();
            nilai.hitungBobot();

            listNilai.add(nilai);
        }

        sc.close();

        System.out.println("Nama Mahasiswa: " + nama);
        System.out.println("Semester: " + semester);
        System.out.println("No.\tKode\t\tMata Kuliah\t\tSKS\tHuruf Mutu\tBobot\tNilai");
        for (int i = 0; i < listNilai.size(); i++) {
            Nilai nilai = listNilai.get(i);

            System.out.println((i+1) + "\t" + nilai.getKode() + "\t\t" + nilai.getMataKuliah() + "\t\t" + nilai.getSks() + "\t" + nilai.getHurufMutu() + "\t\t" + nilai.getBobot() + "\t" + nilai.getNilai());
        }
    }
}

class Nilai {
    private String kode;
    private String mataKuliah;
    private int sks;
    private double nilai;
    private String hurufMutu;
    private double bobot;

    public Nilai() {

    }

    public Nilai(String kode, String mataKuliah, int sks, double nilai) {
        this.kode = kode;
        this.mataKuliah = mataKuliah;
        this.sks = sks;
        this.nilai = nilai;
    }
    
    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public double getNilai() {
        return nilai;
    }

    public void setNilai(double nilai) {
        this.nilai = nilai;
    }

    public String getHurufMutu() {
        return hurufMutu;
    }

    public void setHurufMutu(String hurufMutu) {
        this.hurufMutu = hurufMutu;
    }

    public double getBobot() {
        return bobot;
    }

    public void setBobot(double bobot) {
        this.bobot = bobot;
    }

    public void hitungHurufMutu() {
        if (nilai >= 85) {
            hurufMutu = "A";
        } else if (nilai >= 80) {
            hurufMutu = "A-";
        } else if (nilai >= 75) {
            hurufMutu = "B+";
        } else if (nilai >= 70) {
            hurufMutu = "B";
        } else if (nilai >= 65) {
            hurufMutu = "B-";
        } else if (nilai >= 60) {
            hurufMutu = "C+";
        } else if (nilai >= 55) {
            hurufMutu = "C";
        } else if (nilai >= 40) {
            hurufMutu = "D";
        } else {
            hurufMutu = "E";
        }
    }

    public void hitungBobot() {
        if (hurufMutu.equals("A")) {
            bobot = 4.00;
        } else if (hurufMutu.equals("A-")) {
            bobot = 3.50;
        } else if (hurufMutu.equals("B+")) {
            bobot = 3.00;
        } else if (hurufMutu.equals("B")) {
            bobot = 2.50;
        } else if (hurufMutu.equals("B-")) {
            bobot = 2.00;
        } else if (hurufMutu.equals("C+")) {
            bobot = 1.50;
        } else if (hurufMutu.equals("C")) {
            bobot = 1.00;
        } else if (hurufMutu.equals("D")) {
            bobot = 0.50;
        } else {
            bobot = 0.00;
        }
    }
}
