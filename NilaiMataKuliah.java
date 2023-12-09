import java.util.ArrayList;
import java.util.Scanner;

class NilaiMataKuliah {
    public static String hurufMutu;

    public static void main(String[] args) {
        Scanner inputan = new Scanner(System.in);
        ArrayList<Integer> nilaiList = new ArrayList<Integer>();

        String[] mataKuliah = { "Nilai Dasar Shalih Akram", "Telogi Aswaja", "Civic Education", "Ulumul Qur'an",
                "Sejarah Keuangan Perbankan", "Bahasa Arab I", "Bahasa Inggris", "Pengantar Ekonomi Mikro",
                "Manajemen Syariah", "Pengantar Filsafat", "Bahasa Indonesia" };
        String[] kodeMataKuliah = { "PS0101", "PS0102", "PS0104", "PS0201", "PS0203", "PS0205", "PS0207", "PS0209",
                "PS0218", "PS0227", "PS0416" };
        int[] sks = { 2, 2, 2, 2, 2, 2, 2, 3, 2, 2, 2 };

        System.out.print("Masukkan nama anda : ");
        String namaMahasiswa = inputan.nextLine();

        System.out.print("Masukkan semester : ");
        int semester = inputan.nextInt();

        int totalSks = 0;

        for (int i = 0; i < mataKuliah.length; i++) {
            System.out.printf("Masukkan nilai %s : ", mataKuliah[i]);
            int nilaiMatkul = inputan.nextInt();
            nilaiList.add(nilaiMatkul);
        }

        int no = 1;

        System.out.println("Nama Mahasiswa : " + namaMahasiswa);
        System.out.println("Semeter : " + semester);
        System.out.println("=======================================================================================");
        System.out.println("No\tKode\tMata Kuliah\t\t\t\t\t\tSKS\t\tHuruf Mutu\t\tBobot\t\tNilai");
        System.out.println("=======================================================================================");

        for (int i = 0; i < mataKuliah.length; i++) {
            System.out.printf("%d.\t%s\t%-31s %-7d %-15s %-11.2f %d\n", no, kodeMataKuliah[i], mataKuliah[i], sks[i],
                    hitungHurufMutu(nilaiList.get(i)), hitungBobot(nilaiList.get(i)), nilaiList.get(i));
            no++;
        }

        for (int nilaiSks : sks) {
            totalSks += nilaiSks;
        }
        System.out.printf("Jumlah Total SKS : %d\n", totalSks);
        System.out.println("SKS LIST");

        double rataRata = totalSks / mataKuliah.length;
        System.out.println("IP. Semester : " + rataRata);

        inputan.close();
    }

    public static String hitungHurufMutu(int nilai) {
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
        return hurufMutu;
    }

    public static Double hitungBobot(double bobot) {
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
        return bobot;
    }
}
