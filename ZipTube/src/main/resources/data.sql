INSERT INTO User (user_Id, user_Name, password, first_Name, last_Name, email) VALUES (1, 'jay1', 'pwd321', 'jarrell', 'wells', 'jay@zipstudio.com');
INSERT INTO User (user_Id, user_Name, password, first_Name, last_Name, email) VALUES (2, 'christine1', 'pwd321', 'christine', 'snow', 'christine@zipstudio.com');
INSERT INTO User (user_Id, user_Name, password, first_Name, last_Name, email) VALUES (3, 'hillary1', 'pwd321', 'hillary', 'givhan', 'hillary@zipbank.com');
INSERT INTO User (user_Id, user_Name, password, first_Name, last_Name, email) VALUES (4, 'shu1', 'pwd321', 'shubham', 'amatya', 'shu@zipbank.com');
INSERT INTO User (user_Id, user_Name, password, first_Name, last_Name, email) VALUES (5, 'christian1', 'pwd321', 'christian', 'anderson', 'christian@zipbank.com');

INSERT INTO Video (user_Name, title, videoURL, description, video_Time_Posted) VALUES ('jay1', 'I Love Dogs', 'youtube.dogs.com', 'dogs running', current_timestamp);
INSERT INTO Video (user_Name, title, videoURL, description, video_Time_Posted) VALUES ('christian1', 'Isle of Dogs', 'youtube.isleofdogs.com', 'rescuing dog', current_timestamp);
INSERT INTO Video (user_Name, title, videoURL, description, video_Time_Posted) VALUES ('hillary1', 'Dogs over cats', 'youtube.dogsovercats.com', 'controversial i know', current_timestamp);
INSERT INTO Video (user_Name, title, videoURL, description, video_Time_Posted) VALUES ('shu1', 'I love animals', 'youtube.allanimalsaregreat.com', 'all animals are beautiful', current_timestamp);
INSERT INTO Video (user_Name, title, videoURL, description, video_Time_Posted) VALUES ('christine1', 'Cats 4eva', 'youtube.catsrule.com', 'the obvious truth', current_timestamp);

INSERT INTO Comment (user_Name, video_Id, comment, comment_Date_Posted) VALUES ('christine1', 3, 'AS IF!!!', current_timestamp);
INSERT INTO Comment (user_Name, video_Id, comment, comment_Date_Posted) VALUES ('shu1', 1, 'Yes!!!', current_timestamp);
INSERT INTO Comment (user_Name, video_Id, comment, comment_Date_Posted) VALUES ('christian1', 4, 'You damn dirty apes!!', current_timestamp);
INSERT INTO Comment (user_Name, video_Id, comment, comment_Date_Posted) VALUES ('jay1', 4, 'You not gettin me without a bone.', current_timestamp);
INSERT INTO Comment (user_Name, video_Id, comment, comment_Date_Posted) VALUES ('hillary1', 5, 'HACKED!!! HAHAHA I LOVE CATS MORE THAN DOGS.', current_timestamp);