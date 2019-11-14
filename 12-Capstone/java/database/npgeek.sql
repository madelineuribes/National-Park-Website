INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel)
VALUES('CVNP', 'maddie@gmail.com', 'Ohio', 'inactive');

INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel)
VALUES('CVNP', 'bob@gmail.com', 'Ohio', 'active');

INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel)
VALUES('CVNP', 'mat@gmail.com', 'Ohio', 'active');

INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel)
VALUES('GCNP', 'millb@gmail.com', 'Ari', 'active');

SELECT survey_result.parkcode, parkname, park.state,
count(survey_result.parkcode) AS surveycount FROM survey_result 
JOIN park ON park.parkcode = survey_result.parkcode 
GROUP BY survey_result.parkcode, parkname, park.state ORDER BY surveycount DESC, parkname ASC;

