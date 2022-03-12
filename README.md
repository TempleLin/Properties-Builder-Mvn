How to install: <br/>
1.Clone the repo. <br/>
2.Shell command: "mvn clean install" to install the Maven project to local Maven repository. <br/>
3.Add as dependency for another Maven project. <br/>
<br/>
Repo contains pure builder for properties; and extended builder for Hibernate. <br/> 
Example Usage: <br/>
configProperties = new HibPropsBuilder() <br/>
&nbsp;  .setConDriveClass(HibPropsBuilder.DRIVER.MySql) <br/>
&nbsp;  .setConUrl("jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC") <br/>
&nbsp;  .setConUsername("username") <br/>
&nbsp;  .setConPassword("password") <br/>
&nbsp;  .set_hbm2ddl_auto(HibPropsBuilder.HBM2DDL_AUTO.UPDATE) <br/>
&nbsp;  .setConPoolSize(100) <br/>
&nbsp;  .setDialect(HibPropsBuilder.DIALECT.MySQL55Dialect) <br/>
&nbsp;  .setShowSQL(true) <br/>
&nbsp;  .setCurrContextClass(HibPropsBuilder.CURR_CONTEXT.THREAD); <br/>