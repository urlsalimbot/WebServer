import { Link } from "react-router-dom";
import styles from "./producttype.module.css";
import { useState } from "react";

export default function ProductType({ type, setProdType }) {
  return (
    <div className={styles.typeDiv}>
      <button className={styles.typeBtn} onClick={() => setProdType(type)}>
        {type}
      </button>
    </div>
  );
}
