package nkc_tech.Banking_Rest_Api_Without_Mapper_and_Dto.repository;

import nkc_tech.Banking_Rest_Api_Without_Mapper_and_Dto.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {


}
