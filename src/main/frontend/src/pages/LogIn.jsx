import { Link } from "react-router-dom";
import dunkin from "../assets/dunkin.png";
import donuts from "../assets/donuts.png";
import styles from "./login.module.css";
import LoginForm from "./LoginForm";
export default function LogIn() {
  return (
    <div className={styles.container}>
      {/*TOP*/}
      <div className={`${styles.topDiv} ${styles.sub}`}></div>

      {/*MIDDLE*/}
      <div className={`${styles.midDiv} ${styles.sub}`}>
        <div className={styles.marginDiv}></div>
        <div className={styles.dunkinLogo}>
          <img className={styles.dunkinImg} src={dunkin} />
        </div>
      </div>

      {/*BOTTOM*/}
      <div className={`${styles.botDiv} ${styles.sub}`}>
        <div className={styles.marginDiv}></div>
        <div className={styles.donutsLogo}>
          <img className={styles.donutsImg} src={donuts} />
        </div>
      </div>

      <LoginForm />

      <div className={styles.adminBtnDiv}>
        <Link className={styles.adminBtn} to="/admin">
          Admin
        </Link>
      </div>
    </div>
  );
}
