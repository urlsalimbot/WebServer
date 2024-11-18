import ProductTypes from "../admin-components/product-components/ProductTypes";
import ddLogo from "./assets/dunkindonut.png";
import pinkDonut from "./assets/pinkDonut.png";
import whiteCup from "./assets/cup-white.png";
import styles from "./donutnav.module.css";

export default function DonutNav({ handleClick }) {
  return (
    <div className={styles.navDiv}>
      <div className={styles.ddLogo}>
        <img src={ddLogo} />
      </div>

      <div className={styles.productsDiv}>
        <ProductTypes handleClick={handleClick} />
      </div>

      {/* <div className={styles.botImagesDiv}>
        <img className={styles.pinkDonut} src={pinkDonut} />
        <img className={styles.whiteCup} src={whiteCup} />
      </div> */}
    </div>
  );
}
