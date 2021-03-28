ALTER  TABLE  hermes_app.users
ADD  CONSTRAINT  fk_users_department
FOREIGN  KEY  (department_id)
REFERENCES  hermes_app.departments  (id);