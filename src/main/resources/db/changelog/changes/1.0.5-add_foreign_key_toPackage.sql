ALTER  TABLE  hermes_app.packages
ADD  CONSTRAINT  fk_packages_department_from
FOREIGN  KEY  (department_from)
REFERENCES  hermes_app.departments (id);