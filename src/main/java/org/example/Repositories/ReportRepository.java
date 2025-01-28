package org.example.Repositories;

import org.example.Entity.Film;

import java.util.ArrayList;
import java.util.List;

public interface ReportRepository {

    List<String> getTop10RentedFilms();
    List<String> getMonthlyRentalsAndRevenue();
    List<String> getCustomerActivityReport();

}
