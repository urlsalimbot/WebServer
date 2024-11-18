import { useState } from "react";
import styles from "./item.module.css";
export default function Item({ name, img, price, type, handleItemClick }) {
  //currently not in used from here . . .
  const [quantity, setQty] = useState(0);
  function increment() {
    setQty(quantity + 1);
  }
  function decrement() {
    if (quantity == 0) {
      return;
    }
    setQty(quantity - 1);
  }
  //until here . . .

  return (
    <div className={styles.itemContainer}>
      <div className={styles.nameContainer}>{name}</div>
      <button
        className={styles.itemBtn}
        onClick={() =>
          handleItemClick({
            name: name,
            img: img,
            price: price,
            qty: 1,
            type: type,
          })
        }
      >
        <div className={styles.imgContainer}>
          <img src={img} alt="" />
        </div>
      </button>
    </div>
  );
  {
    /* 
      <div className={styles.nameContainer}>{name}</div>
      <div className={styles.imgContainer}>{img}</div>
      <div className={styles.priceContainer}>{price}</div>
      <div className={styles.btnsContainer}>
        <div className={styles.qtyBtnsContainer}>
          <button
            className={`${styles.decrementBtn} ${styles.qtyItem}`}
            onClick={decrement}
          >
            -
          </button>
          <div>
            <p className={`${styles.qty} ${styles.qtyItem}`}>{quantity}</p>
          </div>
          <button
            className={`${styles.incrementBtn} ${styles.qtyItem}`}
            onClick={increment}
          >
            +
          </button>
        </div>
        <div>
          <button className={styles.selectBtn}>SELECT</button>
        </div>
      </div> 
      */
  }
}
