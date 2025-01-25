package org.example.Service;

import org.example.Repositories.DbRentalRepoImpl;

import java.sql.Timestamp;

public class RentalServices {

   private DbRentalRepoImpl dbRentalRepo ;

   public RentalServices(){
       this.dbRentalRepo = new DbRentalRepoImpl();
   }

    public boolean rentFilm (int customerId,int inventoryId, int staffId){
       return dbRentalRepo.rentFilm(customerId,inventoryId,staffId);
    }

    public boolean returnFilm(int rentalId, Timestamp returnDate){
       return dbRentalRepo.returnFilm(rentalId,returnDate);
    }
}
