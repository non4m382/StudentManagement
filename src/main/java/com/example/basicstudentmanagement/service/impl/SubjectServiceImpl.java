package com.example.basicstudentmanagement.service.impl;

import com.example.basicstudentmanagement.model.Subject;
import com.example.basicstudentmanagement.repository.SubjectRepository;
import com.example.basicstudentmanagement.repository.SubjectStudentRepository;
import com.example.basicstudentmanagement.service.SubjectService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
//@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;

    private final SubjectStudentRepository subjectStudentRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository, SubjectStudentRepository subjectStudentRepository) {
        this.subjectRepository = subjectRepository;
        this.subjectStudentRepository = subjectStudentRepository;
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject findSubjectById(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }

    @Override
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public int getMinStudentBySubjectId(Long id) {
        return subjectRepository.findById(id).get().getMinStudent();
    }

    public void updateSubjectStatus(Long id, String status) {
        Subject subject = subjectRepository.findById(id).get();
        subject.setStatus(status);
        subjectRepository.save(subject);
    }

    @Override
    public String checkCurrentSubjectStatus(Subject subject) {
        String result = "";
        if (subject == null) {
            result = null;
        } else {
            // get subject's current status
            String status = subject.getStatus();

            switch (status) {
                case "closed":
                    result = status;
                    break;
                case "open":
                    // get subject's untilDate
                    LocalDate untilDate = subject.getUntilDate();

                    if (LocalDate.now().isBefore(untilDate) || LocalDate.now().equals(untilDate)) {
                        // still open for registering
                        result = status;
                    } else {
                        // closed for registering
                        int minStudent = subject.getMinStudent();
                        int registeredStudent = subjectStudentRepository
                                .countSubjectStudentBySubjectIdAndStatus(subject.getId(), "registering");

                        if (registeredStudent >= minStudent) { // status = start
                            subject.setStatus("start");
                            result = "start";
                        } else {  // status = closed
                            subject.setStatus("closed");
                            result = "closed";
                        }
                        subjectRepository.save(subject);
                    }
                    break;
                case "start":
                    LocalDate startDate = subject.getStartDate();
                    LocalDate endDate = subject.getEndDate();
                    if (startDate.isAfter(endDate)) { // status = end
                        subject.setStatus("end");
                        subjectRepository.save(subject);
                        result = "end";
                    }
                    break;
                default:
            }
        }
        return result;
    }
}
