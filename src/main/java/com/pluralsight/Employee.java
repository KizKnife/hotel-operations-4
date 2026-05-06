package com.pluralsight;

import java.time.LocalTime;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private LocalTime punchInTime;
    private LocalTime punchOutTime;

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public double getTotalPay() {
        return (getRegularHours() * payRate) + (getOvertimeHours() * payRate * 1.5);
    }

    public double getRegularHours() {
        if (hoursWorked > 40) {
            return 40;
        } else {
            return hoursWorked;
        }
    }

    public double getOvertimeHours() {
        if (hoursWorked > 40) {
            return hoursWorked - 40;
        } else {
            return 0;
        }
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void punchIn(int time) {
        punchInTime = LocalTime.of(time, 0);
    }

    public void punchIn() {
        punchInTime = LocalTime.now();
    }

    public int punchOut(int time) {
        if (punchInTime == null) {
            System.out.println("Must punch in first.");
            return 0;
        }

        LocalTime punchOutTime = LocalTime.of(time, 0);

        int inHour = punchInTime.getHour();
        int outHour = punchOutTime.getHour();

        if (outHour >= inHour) {
            return outHour - inHour;
        }

        // Handles overnight shift
        return (24 - inHour) + outHour;
    }

    public void punchOut() {
        if (punchInTime == null) {
            System.out.println("Must punch in first.");
            return;
        }

        punchOutTime = LocalTime.now();

        int inHour = punchInTime.getHour();
        int outHour = punchOutTime.getHour();

        double hours;

        if (outHour >= inHour) {
            hours = outHour - inHour;
        } else {
            hours = (24 - inHour) + outHour;
        }

        hoursWorked += hours;
    }

    public String toString() {
        return String.format(
                "ID: %s%n" +
                "Name: %s%n" +
                "Department: %s%n" +
                "Pay Rate: $%.2f%n" +
                "Hours Worked: %.2fhrs%n" +
                "Total Pay: $%.2f%n",
                getEmployeeId(),
                getName(),
                getDepartment(),
                getPayRate(),
                getHoursWorked(),
                getTotalPay()
        );
    }
}