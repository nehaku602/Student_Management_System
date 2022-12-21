package com.platformcommon.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platformcommon.DTO.CourseDTO;
import com.platformcommon.DTO.StudentAddressDTO;
import com.platformcommon.DTO.StudentCourse;
import com.platformcommon.DTO.StudentDTO;
import com.platformcommon.DTO.StudentUpdateDTO;
import com.platformcommon.entity.Address;
import com.platformcommon.entity.Course;
import com.platformcommon.entity.Student;
import com.platformcommon.exception.CourseException;
import com.platformcommon.exception.StudentException;
import com.platformcommon.exception.UserException;
import com.platformcommon.respository.AddressDao;
import com.platformcommon.respository.CourseDao;
import com.platformcommon.respository.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressDao addressDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CourseDao courseDao;
	
	
	@Override
	public StudentDTO registerStudent(StudentDTO studentDTO) throws StudentException, UserException {
		
		Student student = dtoToStudent(studentDTO);
		
		student = studentDao.save(student) ;		
			
		return studentToDTO(student);
	}
	
	
	@Override
	public Student getStudentById(Integer studentId) throws StudentException {
		
		return studentDao.findById(studentId).orElseThrow(() -> new StudentException("Invalid StudentId "+ studentId)) ;
	}

	@Override
	public List<Course> getAllCoursesAdminPurpose(Integer studentId) throws StudentException {
		
		return studentDao.findById(studentId).orElseThrow(() -> new StudentException("Invalid StudentId "+ studentId)).getCourses();

	}

	@Override
	public List<StudentDTO> getStudentByName(String name) throws StudentException {
		
		List<Student> students = studentDao.getStudentsByName(name);
		
		if(students.isEmpty()) 
			throw new StudentException("No student found with name : "+name) ;

		List<StudentDTO> studentsDTO =  students
										.stream()
										.map(student -> this.studentToDTO(student)).collect(Collectors.toList()) ;

		return studentsDTO;
	}

	@Override
	public StudentDTO updateEmailAndMobile(StudentUpdateDTO dto) throws StudentException {
		
		Student student = validateStudentIdAndDOB(dto.getStudentId(), dto.getDob());
		
		if(student  == null) 
			throw new StudentException("Invalid StudentId Or DOB!") ;
		
		student.setMobileNumber(dto.getNewMobileNumber());
		student.setEmail(dto.getNewEmail());
		
		student = studentDao.save(student) ;
		
		return studentToDTO(student);
	}


	@Override
	public StudentDTO updateStudentAddress(StudentAddressDTO addressDTO) throws StudentException {
		
//		Student student =  validateStudentIdAndDOB(addressDTO.getStudentId(), addressDTO.getDob());
		
		Student student = validateStudentIdAndDOB(addressDTO.getStudentId(), addressDTO.getDob());
		
		List<Address> addressList =  student.getAddress();
		
		for(Address address : addressList) {
			if(address.getAddressId().equals(addressDTO.getAddress().getAddressId())) {
				addressDao.save(addressDTO.getAddress()) ;
			}
		}
		
		Student updatedStudent = studentDao.findById(student.getStudentId()).orElseThrow(() -> new StudentException("Invalid StudentId "+ student.getStudentId())) ;
		
		return studentToDTO(updatedStudent);
	}
	
	
	@Override
	public StudentDTO addNewAddress(StudentAddressDTO addressDTO) throws StudentException {
		
		Student student =  validateStudentIdAndDOB(addressDTO.getStudentId(), addressDTO.getDob());
		List<Address> addressList =  student.getAddress();
		
		List<Address> filterAddress = addressList.stream().filter(address -> address.getAddressType().equals(addressDTO.getAddress().getAddressType())).collect(Collectors.toList());
		if(filterAddress.size() != 0) 
			throw new StudentException("Address type : "+ addressDTO.getAddress().getAddressType() +" is already added!. You have to update the address") ;
		
		student.getAddress().add(addressDTO.getAddress()) ;
		Student updateStudent = studentDao.save(student) ;
		
		return studentToDTO(updateStudent);
	}
	
	
	public Student validateStudentIdAndDOB(Integer studentId,LocalDate dob) {
		
		Optional<Student> studentOpt = studentDao.findById(studentId);
		
		if(studentOpt.isEmpty()) 
			return null;
		
		Student student = studentOpt.get();
		
		if(!dob.equals(student.getDob())) 
			return null;
		
		return student;
	}
	
	
	
	@Override
	public StudentCourse getStudentCourses(Integer studentId, String dateOfBirth) throws StudentException {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dob = LocalDate.parse(dateOfBirth, formatter);
				
		Student student = validateStudentIdAndDOB(studentId,dob) ;
		if(student == null) 
			throw new StudentException("Invalid student Id or Passord") ;
		
	
		return coursesToStudentCourse(student.getCourses(), student);
	}
	
	
	
	@Override
	public StudentCourse leaveCourse(Integer studentId, String dateOfBirth, Integer courseId) throws StudentException, CourseException {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dob = LocalDate.parse(dateOfBirth, formatter);
				
		Student student = validateStudentIdAndDOB(studentId,dob) ;
		Course course = courseDao.findById(courseId).orElseThrow(()-> new CourseException("Invalid courseId: "+courseId)) ;
//		List<Course> courses = student.getCourses();
		
		if(student.getCourses().contains(course)) {
			student.getCourses().remove(course) ;
		}
		
		if(course.getStudents().contains(student)) {
			course.getStudents().remove(student) ;
		}
		courseDao.save(course) ;
		
		student = studentDao.save(student) ;
		
		return coursesToStudentCourse(student.getCourses(), student);
	}
	
	@Override
	public StudentCourse coursesToStudentCourse(List<Course> courses,Student student) {
		
		StudentCourse studentCourse = new StudentCourse();
		studentCourse.setStudentId(student.getStudentId());
		studentCourse.setName(student.getName());
		
		List<CourseDTO> courseDTOList = new ArrayList<>();
		for(Course singleCourse : student.getCourses()) {
			
			CourseDTO dto = new CourseDTO();
			BeanUtils.copyProperties(singleCourse, dto);
			courseDTOList.add(dto) ;
		}
		
		studentCourse.setCourses(courseDTOList);
		
		return studentCourse;
	}

	
	public Student dtoToStudent(StudentDTO studentDTO) {
		return this.modelMapper.map(studentDTO, Student.class);
	}
	
	public StudentDTO studentToDTO(Student student) {
		return this.modelMapper.map(student, StudentDTO.class);
	}

}

