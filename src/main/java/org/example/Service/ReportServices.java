package org.example.Service;

import org.example.Repositories.DBReportRepoImpl;

import java.util.List;

public class ReportServices {

    DBReportRepoImpl dbReportRepo;

    public ReportServices(){
        this.dbReportRepo = new DBReportRepoImpl();
    }

    public List<String> getTop10RentedFilms(){
       return dbReportRepo.getTop10RentedFilms();
    }

    public List<String> getMonthlyRentalsAndRevenue(){
        return dbReportRepo.getMonthlyRentalsAndRevenue();
    }

    public List<String> getCustomerActivityReport(){
        return dbReportRepo.getCustomerActivityReport();
    }
}
