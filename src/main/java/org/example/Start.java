package org.example;

import org.example.utils.ScannerUtils;

public class Start {

    private int numberRows;
    private int numberSeatsRow;
    char[][] cinema;
    Ticket ticket;

    public void start(){
        System.out.println("Enter the number of rows:");
        setNumberRows(ScannerUtils.nextIntAndMoveToNextLine());
        System.out.println("Enter the number of seats in each row:");
        setNumberSeatsRow(ScannerUtils.nextIntAndMoveToNextLine());
        setCinema(initCinema(getNumberRows(),getNumberSeatsRow()));
        ticket = new Ticket();
        ticket.setTotalIncome(getNumberRows(),getNumberSeatsRow());
        ticket.setTotalCount(getNumberRows(),getNumberSeatsRow());

        menu();

    }

    public void menu() {
        start:
        for (; ; ) {
            int chose;
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            chose = ScannerUtils.nextIntAndMoveToNextLine();
            switch (chose) {
                case 1:
                    showTheSeats(getCinema(), getNumberRows(), getNumberSeatsRow());
                    break;
                case 2:
                    ticket.buyATicket(getCinema(), getNumberRows(), getNumberSeatsRow());
                    break;
                case 3:
                    ticket.showStatistics();
                    break;
                case 0:
                    break start;
            }
        }

    }

    public char[][] initCinema(int rows, int seatsRow){
        char[][] cinema = new char[rows][seatsRow];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsRow; j++) {
                cinema[i][j] = 'S';
            }
        }
        return cinema;
    }

    public static void showTheSeats(char[][] cinema, int numberRows, int numberSeatsRow) {
        System.out.println();
        System.out.println("Cinema:");
        for (int i = 0; i <= numberSeatsRow; i++)
            if (i == 0)
                System.out.print(" ");
            else
                System.out.print(" " + i);
        System.out.println();

        for (int i = 0; i < numberRows; i++) {
            System.out.print((i+1));
            for (int j = 0; j < numberSeatsRow; j++) {
                System.out.print(" " + cinema[i][j]);
            }
            System.out.println();
        }
    }

    public int getNumberRows() {
        return numberRows;
    }

    public void setNumberRows(int numberRows) {
        this.numberRows = numberRows;
    }

    public int getNumberSeatsRow() {
        return numberSeatsRow;
    }

    public void setNumberSeatsRow(int numberSeatsRow) {
        this.numberSeatsRow = numberSeatsRow;
    }

    public char[][] getCinema() {
        return cinema;
    }

    public void setCinema(char[][] cinema) {
        this.cinema = cinema;
    }
}
