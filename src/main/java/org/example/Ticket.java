package org.example;

import org.example.utils.ScannerUtils;

public class Ticket {

    private int rows;
    private int seatRows;
    private int count = 0;
    private int curentIncome = 0;
    private int totalIncome;
    private int totalCount;

    public Ticket() {
    }

    public void buyATicket(char[][] cinema, int numberRows, int numberSeatsRow) {
        boolean test = false;
        do {
            System.out.println();
            System.out.print("Enter a row number: ");
            setRows(ScannerUtils.nextIntAndMoveToNextLine());
            System.out.print("Enter a seat number in that row: ");
            setSeatRows(ScannerUtils.nextIntAndMoveToNextLine());

            if (getRows() > numberRows || getSeatRows() > numberSeatsRow) {
                System.out.println("\nWrong input!");
            } else if (cinema[getRows() - 1][getSeatRows() - 1] == 'B')
                System.out.println("\nThat ticket has already been purchased!");
            else {
                if (numberRows * numberSeatsRow > 60)
                    if (numberRows % 2 == 0 & getRows() <= numberRows / 2) {
                        System.out.println("\nTicket price: $10");
                        setCurentIncome(getCurentIncome() + 10);
                    } else if ((numberRows - 1) % 2 == 0 & getRows() <= numberRows / 2) {
                        System.out.println("\nTicket price: $10");
                        setCurentIncome(getCurentIncome() + 10);
                    } else {
                        System.out.println("\nTicket price: $8");
                        setCurentIncome(getCurentIncome() + 8);
                    }
                else {
                    System.out.println("\nTicket price: $10");
                    setCurentIncome(getCurentIncome() + 10);
                }
                test = true;
                cinema[getRows() - 1][getSeatRows() - 1] = 'B';
                setCount(getCount() + 1);
            }
        } while (!test);

    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getSeatRows() {
        return seatRows;
    }

    public void setSeatRows(int seatRows) {
        this.seatRows = seatRows;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCurentIncome() {
        return curentIncome;
    }

    public void setCurentIncome(int curentIncome) {
        this.curentIncome = curentIncome;
    }

    public int getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(int r, int s) {
        int totalIncomer = 0;
        if (r * s > 60)
            if (r % 2 == 0) {
                totalIncomer += r / 2 * s * 10;
                totalIncomer += (r - r / 2) * s * 8;
            } else {
                totalIncomer += (r - 1) / 2 * s * 10;
                totalIncomer += (r - (r - 1) / 2) * s * 8;
            }
        else
            totalIncomer += r * s * 10;
        this.totalIncome = totalIncomer;
    }

    public void showStatistics() {
        System.out.println();
        System.out.println("Number of purchased tickets: " + getCount());
        System.out.printf("Percentage: %.2f", procentage());
        System.out.println("%");
        System.out.println("Current income: $" + getCurentIncome());
        System.out.println("Total income: $" + getTotalIncome());
    }


    public double procentage() {
        return (double) getCount() / getTotalCount() * 100;
    }


    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int a, int b) {
        this.totalCount = a * b;
    }

}
