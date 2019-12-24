-- Include table data insertion, updation, deletion and select scripts
use movie_cruiser;

-- View movie list admin
INSERT INTO `movie_cruiser`.`movie`
(`mo_id`,
`mo_title`,
`mo_box_office`,
`mo_active`,
`mo_date_of_launch`,
`mo_Genre`,
`mo_has_teaser`)
VALUES
(
1,
'Avatar',
2787965087,
'Yes',
'2017-03-15',
'ScienceFiction',
'Yes'),
(
2,
'The Avengers',
1518812988,
'Yes',
'2017-12-23',
'Superhero',
'No'),
(
3,
'Titanic',
2187463944,
'Yes',
'2017-08-21',
'Romance',
'No'),
(
4,
'Jurassic World',
1671713208,
'No',
'2017-07-02',
'ScienceFiction',
'Yes'),
(
5,
'Avengers: End Game',
2750560348,
'Yes',
'2022-11-02',
'Superhero',
'Yes');


SELECT mo_id, mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_Genre, mo_has_teaser
FROM `movie_cruiser`.`movie`;


-- view movie list customer

SELECT mo_id, mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_Genre, mo_has_teaser 
FROM  `movie_cruiser`.`movie` 
WHERE mo_date_of_launch <= curdate() 
AND mo_active = 'Yes';


-- edit movie

SELECT mo_id, mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_Genre, mo_has_teaser 
FROM  `movie_cruiser`.`movie` 
WHERE mo_id = 2;

UPDATE `movie_cruiser`.`movie`
SET
mo_title = 'Tangle', mo_box_office = 2787965087, 
mo_active = 'Yes', mo_date_of_launch = '2017-12-01', mo_Genre = 'Cartoon', mo_has_teaser = 'Yes'
WHERE mo_id = 1;


-- add to favorite

INSERT INTO `movie_cruiser`.`user` 
VALUES(1,'Danny'),(2,'Conny');

SELECT us_id, us_name
FROM `movie_cruiser`.`user`;

INSERT INTO  `movie_cruiser`.`favorite` 
VALUES(1,1,2),(2,1,4),(3,1,1);


-- view favorite

SELECT fa_id, fa_us_id, fa_pr_id
FROM `movie_cruiser`.`favorite`;

SELECT count(fa_pr_id) 
FROM  `movie_cruiser`.`favorite` 
WHERE fa_us_id = 1;


-- remove favorite

DELETE FROM`movie_cruiser`.`favorite`
WHERE fa_us_id = 1 AND fa_pr_id = 1;

SELECT fa_id, fa_us_id, fa_pr_id
FROM `movie_cruiser`.`favorite`;



-- check
SELECT
`favorite`.`fa_id`,
`favorite`.`fa_us_id`,
`favorite`.`fa_pr_id`
FROM `movie_cruiser`.`favorite`
join `movie_cruiser`.`movie`
WHERE movie.mo_id = fa_pr_id and fa_us_id = 1;
