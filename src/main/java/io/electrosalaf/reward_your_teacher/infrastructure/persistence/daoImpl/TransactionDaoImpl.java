package io.electrosalaf.reward_your_teacher.infrastructure.persistence.daoImpl;

import io.electrosalaf.reward_your_teacher.domain.dao.TransactionDao;
import io.electrosalaf.reward_your_teacher.domain.entities.StudentEntity;
import io.electrosalaf.reward_your_teacher.domain.entities.TeacherEntity;
import io.electrosalaf.reward_your_teacher.domain.entities.transact.TransactionEntity;
import io.electrosalaf.reward_your_teacher.infrastructure.persistence.repository.TransactionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransactionDaoImpl extends CrudDaoImpl<TransactionEntity, Long> implements TransactionDao {
    private final TransactionRepository transactionRepository;

    protected TransactionDaoImpl(TransactionRepository transactionRepository) {
        super(transactionRepository);
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Page<TransactionEntity> findTransactionEntitiesByStudent(Pageable pageable, StudentEntity student) {
        return transactionRepository.findTransactionEntitiesByStudent(pageable,student);
    }



    @Override
    public Page<TransactionEntity> findTransactionEntitiesByTeacher(Pageable pageable, TeacherEntity teacher) {
        return transactionRepository.findTransactionEntitiesByTeacher(pageable,teacher);
    }
}
