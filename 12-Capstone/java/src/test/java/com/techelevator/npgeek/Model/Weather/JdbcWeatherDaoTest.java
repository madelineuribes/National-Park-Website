package com.techelevator.npgeek.Model.Weather;

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

import com.techelevator.npgeek.Model.Weather.JdbcWeatherDao;
import com.techelevator.npgeek.Model.Weather.WeatherDao;

public class JdbcWeatherDaoTest {

	private static SingleConnectionDataSource dataSource;
	private WeatherDao dao;
	
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
		dao = new JdbcWeatherDao(dataSource);
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	protected DataSource getDataSource() {
		return dataSource;
	}
	
	@Test
	public void testGetWeatherByIdListSizeReturns5() {
		List<Weather> weatherList = dao.getWeatherById("GCNP");
		assertEquals(5, weatherList.size());
	}
	
	@Test
	public void testGetWeatherByIdGNPSecondDayLowValueIs31() {
		List<Weather> weatherList = dao.getWeatherById("GNP");
		Weather testWeather = weatherList.get(1);
		assertEquals(31, testWeather.getLowF(), 0.0);
	}

}
