package com.techelevator.npgeek.Model.Park;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.npgeek.Model.Park.Park;
import com.techelevator.npgeek.Model.Park.ParkDao;

public class JdbcParkDaoTest {

	private static SingleConnectionDataSource dataSource;
	private ParkDao dao;
	
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
		dao = new JdbcParkDao(dataSource);
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	protected DataSource getDataSource() {
		return dataSource;
	}
	
	@Test
	public void testGetAllParksReturnsHowManyParks() {
		List<Park> parkList = dao.getAllParks();
		assertEquals(10, parkList.size());
	}
	
	@Test
	public void testGetAllParksReturnsFirstParkName () {
		List<Park> parkList = dao.getAllParks();
		Park testParkName = parkList.get(0);
		assertEquals("Cuyahoga Valley National Park", testParkName.getName());		
	}
	
	@Test
	public void testGetAllParksReturnsFirstParkState() {
		List<Park> parkList = dao.getAllParks();
		Park testParkState = parkList.get(0);
		assertEquals("Ohio", testParkState.getState());		
	}
	
	@Test
	public void testGetAllParksReturnsLastParkName() {
		List<Park> parkList = dao.getAllParks();
		Park testParkState = parkList.get(parkList.size() - 1);
		assertEquals("Yosemite National Park", testParkState.getName());		
	}
	
	@Test
	public void testGetAllParksReturnsLastParkState() {
		List<Park> parkList = dao.getAllParks();
		Park testParkState = parkList.get(parkList.size() - 1);
		assertEquals("California", testParkState.getState());		
	}
	
	@Test
	public void testGetParkByIdCVNPReturnsClimateWoodland() {
		Park park = dao.getParkById("CVNP");
		assertEquals("Woodland", park.getClimate());
	}
	
	@Test
	public void testGetParkByIdYNP2ReturnsClimateWoodland() {
		Park park = dao.getParkById("YNP2");
		assertEquals(747956, park.getAcreage());
	}
}
