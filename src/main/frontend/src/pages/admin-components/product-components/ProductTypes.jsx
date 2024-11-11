import { useState } from "react";
import styles from "./producttypes.module.css";
import ProductType from "./ProductType";

export default function ProductTypes({ setProdType }) {
  // const [products, setProducts] = useState([]);

  return (
    <div className={styles.container}>
      <ProductType type={"Premium Donuts"} setProdType={setProdType} />
      <ProductType type={"Classic Donuts"} setProdType={setProdType} />
      <ProductType type={"Drinks"} setProdType={setProdType} />
      <ProductType type={"Munchkins"} setProdType={setProdType} />
    </div>
  );
}
