import styles from "./summaryitem.module.css";

export default function SummaryItem({
  item,
  summaryItems,
  addItem,
  name,
  img,
  price,
  qty,
  isBundle,
}) {
  //deletes and item
  function handleDelete() {
    addItem(summaryItems.filter((i) => i !== item));
  }

  //decreases the number of items
  function handleDecrement() {
    const index = summaryItems.indexOf(item);
    summaryItems[index].qty = summaryItems[index].qty - 1;
    if (summaryItems[index].qty <= 0) {
      addItem(summaryItems.filter((i) => i !== item));
    } else {
      addItem([...summaryItems]);
    }
  }
  if (isBundle) {
    return (
      <div className={styles.summaryItemContainer}>
        <div className={styles.summaryItemImg}>
          <img src={img} alt="donut" />
        </div>
        <div className={styles.itemDetails}>
          <div className={styles.summaryItemName}>{name}</div>
        </div>
        <div className={styles.qtyContainer}>
          <div className={styles.summaryItemQty}>{qty}</div>
        </div>
      </div>
    );
  } else {
    return (
      <div className={styles.summaryItemContainer}>
        <div className={styles.summaryItemImg}>
          <img src={img} alt="donut" />
        </div>
        <div className={styles.itemDetails}>
          <div className={styles.summaryItemName}>{name}</div>
          <div className={styles.summaryItemPrice}>₱ {price}</div>
        </div>
        <div className={styles.qtyContainer}>
          <button
            className={styles.decrementBtn}
            onClick={() => handleDecrement()}
          >
            -
          </button>
          <div className={styles.summaryItemQty}>{qty}</div>
        </div>
        <div className={styles.deleteBtnDiv}>
          <button className={styles.deleteBtn} onClick={() => handleDelete()}>
            x
          </button>
        </div>
      </div>
    );
  }
}
