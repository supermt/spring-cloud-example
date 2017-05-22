package edu.uestc.msstudio.supermt.cloud.web.repository;

import edu.uestc.msstudio.supermt.cloud.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by MT on 2017/5/22.
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long>
{
    @Query("select U from User U where U.username = ?2")
    Page<User> findByUsername(Pageable sort,String username);
}
