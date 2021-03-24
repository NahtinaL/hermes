ALTER  TABLE  hermes_app.packages
ADD  CONSTRAINT  fk_packages_department_to
FOREIGN  KEY  (department_to)
REFERENCES  hermes_app.departments  (id);
