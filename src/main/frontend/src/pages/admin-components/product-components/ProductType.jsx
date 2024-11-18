import { Link } from "react-router-dom";
import styles from "./producttype.module.css";
import { useState } from "react";

export default function ProductType({ type, handleClick }) {
  return (
    <div className={styles.typeDiv}>
      <button className={styles.typeBtn} onClick={() => handleClick(type)}>
        {type}
      </button>
    </div>
  );
}
