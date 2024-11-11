import donutsml from "../assets/donutsml.png";
import cup from "../assets/cup.png";
import pinkdonut from "../assets/pinkdonut.png";
import styles from "./loginform.module.css";
import { useState } from "react";
export default function LoginForm() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const tempUserName = "group5";
  const tempPassword = "123";

  function handleSubmit(e) {
    e.preventDefault(); //prevents from refreshing the page
    //FOR IMPLEMENTATION OF LOG IN
    console.log(username);
    console.log(password);
    if (username === tempUserName && password === tempPassword) {
      window.location.assign("http://localhost:5173/orderpage");
      console.log("executed");
    }
    //UNTIL THIS LINE
  }

  return (
    <div className={styles.loginDiv}>
      <img className={styles.donutsml} src={donutsml} />
      <form action="" onSubmit={handleSubmit}>
        <input
          type="text"
          onChange={(e) => setUsername(e.target.value)}
          className={styles.textBox}
          placeholder="Username"
          value={username}
        />
        <input
          type="password"
          onChange={(e) => setPassword(e.target.value)}
          className={styles.textBox}
          placeholder="Password"
          value={password}
        />
        <button type="submit" className={styles.loginBtn}>
          Log In
        </button>
      </form>
      <img className={styles.cup} src={cup} />
      <img className={styles.donut} src={pinkdonut} />
    </div>
  );
}
