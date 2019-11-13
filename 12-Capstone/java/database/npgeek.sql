INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel)
VALUES('CVNP', 'maddie@gmail.com', 'Ohio', 'inactive');

SELECT survey_result.parkcode, parkname,
count(survey_result.parkcode) AS surveycount FROM survey_result 
JOIN park ON park.parkcode = survey_result.parkcode 
GROUP BY survey_result.parkcode, parkname ORDER BY surveycount DESC, parkname ASC;

ROLLBACK;