package com.techelevator.npgeek.Model.Survey;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.npgeek.Model.Survey.Survey;
import com.techelevator.npgeek.Model.Park.Park;
import com.techelevator.npgeek.Model.Survey.JdbcSurveyDao;

public class JdbcSurveyDaoTest {

	private static SingleConnectionDataSource dataSource;
	private SurveyDao dao;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}

	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	@Before
	public void setUp() throws Exception {
		dao = new JdbcSurveyDao(dataSource);
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	protected DataSource getDataSource() {
		return dataSource;
	}

	@Test
	public void saveNewSurveyReturnsOneSurveyCount() {
		Survey testSurvey = new Survey();
		testSurvey.setParkCode("MRNP");
		testSurvey.setEmail("email");
		testSurvey.setState("ohio");
		testSurvey.setActivityLevel("busy");
		
		dao.save(testSurvey);
		
		List<Park> parkList = new ArrayList<>();
		parkList = dao.getNumOfSurveysTaken();
		
		Park newSurvey = parkList.get(parkList.size() - 1);
		
		assertEquals(1, newSurvey.getSurveyCount());		
	}
	
	@Test
	public void getTotalCountOfParksThatHaveSurveys() {		
		List<Park> parkList = dao.getNumOfSurveysTaken();
		assertEquals(7, parkList.size());		
	}
	
	@Test
	public void getNumOfSurveyCountForCVNP() {		
		List<Park> parkList = dao.getNumOfSurveysTaken();
		Park park = parkList.get(0);
		assertEquals(6, park.getSurveyCount());		
	}

}
