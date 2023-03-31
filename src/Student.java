public class Student {
    String studentName,enrollmentNumber;
    String libID;  // Student's library id
    int[] issuedBookID={0,0,0};  // Array of issued books
    String [] issueDate={null,null,null};   // Array of issue dates
    String [] returnDate={null,null,null};  // Array of return date
    static int serial=1001;
    Student(String studentName,String enrollmentNumber) {
        libID="S"+serial++;
        this.studentName=studentName;
        this.enrollmentNumber=enrollmentNumber;
    }
    Student() {
    // Do nothing constructor
    }
    void registration(String enrollmentNumber) {
        // To give student id and add student name
        this.enrollmentNumber=enrollmentNumber;
        libID="S"+serial;
        serial++;
        System.out.print("Student name : ");
        studentName=Library.scan.nextLine();
    }
    void displayStudent() {
        // To display all Students
        System.out.print(libID+"   ");
        System.out.print(enrollmentNumber);
        spaceEnroll();
        System.out.print(studentName+"\n");
    }
    void header() {
        System.out.println("  ID   "+"Enrollment Number     "+"  Student name");
    }
    void spaceEnroll() {
        // To add some extra space for better looks
        int space=22-enrollmentNumber.length();
        if(space<0){
            System.out.print("     ");
        } else {
            int i = 0;
            while (i < space) {
                System.out.print(" ");
                i++;
            }
        }
    }
    void displayOneStudent() {
        // To display details of searched student id
        System.out.println("Id : "+libID+"\nEnrollment Number : "+enrollmentNumber+"\nName : "+studentName);
        System.out.println();
        System.out.println("Issued Book");
        int count=0;
        for(int i=0;i<3;i++) {
            if(issuedBookID[i]!=0) {
                for(int j=0;j<100;j++) {
                    if(Library.book[j].bookID==issuedBookID[i]) {
                        System.out.println("Book ID : "+ Library.book[j].bookID+"     Book Name :"+ Library.book[j].bookName);
                        break;
                    }
                }
                count++;
            }
        }
        if(count==0) {
            System.out.println("None");
        }
    }
    int count(){
        // To count number of issued books
        int countIssuedBook=0;
        for(int i=0;i<3;i++) {
            if(issuedBookID[i]!=0) {
                countIssuedBook++;
            }
        }
        return (countIssuedBook);
    }
    void issueBook(int id,String date) {
        // To add book id to issued book and take issue date
        for(int i=0;i<3;i++) {
            if(issuedBookID[i]==0) {
                issuedBookID[i]=id;
                issueDate[i]=date;
                break;
            }
        }
    }
    boolean checkBook(int id) {
        // To check book id in issued books
        for(int i=0;i<3;i++) {
            if(issuedBookID[i]==id) {
                return  true;
            }
        }
        return false;
    }
    int returnBook(int id,String date) {
        // To remove book from issued book and take return date
        for(int i=0;i<3;i++) {
            if(issuedBookID[i]==id) {
                issuedBookID[i]=0;
                returnDate[i]=date;
                int days = calculateNoOfDays(i);
                returnDate[i] = null;
                return (days);
            }
        }
        return 0;
    }
    boolean checkReturnDate(int id,String returnDate) {
        int i;
        for(i=0;i<3;i++) {
            if(issuedBookID[i]==id) {
                break;
            }
        }
        String [] issue=issueDate[i].split(" ");
        int issueDay=Integer.parseInt(issue[0]);
        int issueMonth=Integer.parseInt(issue[1]);
        int issueYear=Integer.parseInt(issue[2]);
        String [] returnD=returnDate.split(" ");
        int returnDay=Integer.parseInt(returnD[0]);
        int returnMonth=Integer.parseInt(returnD[1]);
        int returnYear=Integer.parseInt(returnD[2]);
        if(returnYear>issueYear) {
            return true;
        } else if (returnYear==issueYear) {
            if(returnMonth>issueMonth) {
                return true;
            } else if (returnMonth==issueMonth) {
                return returnDay >= issueDay;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    // Two methods to calculate number of days between issue date and return date
    int calculateNoOfDays(int i) {
        int days;
        String [] issue=issueDate[i].split(" ");
        int issueDay=Integer.parseInt(issue[0]);
        int issueMonth=Integer.parseInt(issue[1]);
        int issueYear=Integer.parseInt(issue[2]);
        String [] returnD=returnDate[i].split(" ");
        int returnDay=Integer.parseInt(returnD[0]);
        int returnMonth=Integer.parseInt(returnD[1]);
        int returnYear=Integer.parseInt(returnD[2]);
        boolean issueLeapYear= (issueYear%4==0 && issueYear%100!=0)||(issueYear%400==0);
        boolean returnLeapYear= (returnYear%4==0 && returnYear%100!=0)||(returnYear%400==0);
        if (issueMonth == returnMonth && issueYear==returnYear) {
            days = returnDay - issueDay +1;
        } else {
            int extraMonthDays=0;
            int issueMonthDays=calculateDaysOfMonths(issueMonth,issueLeapYear)-issueDay+1;
            if(issueYear==returnYear) {
                if (issueMonth+1 != returnMonth) {
                    for (int month = issueMonth+1; month < returnMonth; month++) {
                        extraMonthDays+=calculateDaysOfMonths(month,issueLeapYear);
                    }
                }
            } else {
                int years=returnYear-issueYear-1;
                for(int year=1;year<=years;year++) {
                    if(((issueYear+year)%4==0 && (issueYear+year)%100!=0)||((issueYear+year)%400==0)) {
                        extraMonthDays+=366;
                    } else {
                        extraMonthDays+=365;
                    }
                }
                for (int month = issueMonth+1; month <=12; month++) {
                    extraMonthDays+=calculateDaysOfMonths(month,issueLeapYear);
                }
                for (int month = 1; month <returnMonth; month++) {
                    extraMonthDays+=calculateDaysOfMonths(month,returnLeapYear);
                }
            }
            days=returnDay+issueMonthDays+extraMonthDays;
        }
        return days;
    }
    int calculateDaysOfMonths(int month,boolean leapYear) {
        int day=0;
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> day += 31;
            case 2 -> {
                if (leapYear) {
                    day += 29;
                } else {
                    day += 28;
                }
            }
            case 4, 6, 9, 11 -> day += 30;
        }
        return day;
    }
}