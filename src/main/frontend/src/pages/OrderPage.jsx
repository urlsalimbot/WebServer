import DonutNav from "./orderpage-components/DonutNav";
import OrderSummaryContainer from "./orderpage-components/OrderSummaryContainer";
import styles from "./orderpage.module.css";
import ClassicDonuts from "./orderpage-components/products-components/ClassicDonuts";
import Drinks from "./orderpage-components/products-components/Drinks";
import PremiumDonuts from "./orderpage-components/products-components/PremiumDonuts";
import Sandwiches from "./orderpage-components/products-components/Sandwiches";
import Bundles from "./orderpage-components/products-components/Bundles";
import { useEffect, useRef, useState } from "react";

export default function OrderPage() {
  const [summaryItems, addItem] = useState([]); //stores single orders; array of donuts
  const [summaryBundles, addBundle] = useState([]); //stores bundle orders; array ng bundles -> {array of Premium donuts; array classic donuts}
  const [bundleClassic, setBundleClassic] = useState([]);
  const [bundlePremium, setBundlePremium] = useState([]);
  const [numOfClassic, setNumOfClassic] = useState(0);
  const [numOfPremium, setNumOfPremium] = useState(0);
  const [isBundle, setIsBundle] = useState(false); //becomse true when the order is Bundle type
  const [currentBundle, setCurrentBundle] = useState(-1);

  function reset() {
    addItem([]);
    addBundle([]);
    setBundleClassic([]);
    setBundlePremium([]);
    setNumOfClassic(0);
    setNumOfPremium(0);
    setIsBundle(false);
    setCurrentBundle(-1);
  }

  /**
   * When isBundle changes, do the following code
     Executes whenever the user:
     1. clicks the bundle
     2. the Bundle box is fulll
     3. a bundle is deleted from the summary by delete button/completed transaction
   */
  useEffect(() => {
    console.log("isBundle is " + isBundle);
    console.log("currentBundle index is " + currentBundle);

    //if bundle is false and current bundle is not empty
    if (!isBundle && summaryBundles[currentBundle] != null) {
      //if premium and classic arrays are full, transfer to bundle array
      if (
        summaryBundles[currentBundle].classicFull &&
        summaryBundles[currentBundle].premiumFull
      ) {
        //transfer the donuts from temporary arrays to the bundle object
        // console.log("Classic and Premium transferred to bundle object array");
        if (
          numOfPremium == summaryBundles[currentBundle].numPremium &&
          numOfClassic == summaryBundles[currentBundle].numClassic
        ) {
          summaryBundles[currentBundle].bundlePremium = bundlePremium;
          summaryBundles[currentBundle].bundleClassic = bundleClassic;
        }
        //reset the (bundle arrays) and (donut count) to be used by the next bundle for rendering
        setBundleClassic([]);
        setBundlePremium([]);
        setNumOfClassic(0);
        setNumOfPremium(0);
      } else {
        //else, set (isBundle) to true, this happens when a
        //bundle item is deleted and there is still a current bundle which is not full
        setIsBundle(true);
      }
    } else if (!isBundle && summaryBundles[currentBundle] == null) {
      console.log("current Bundle is null");
      //when bundles are deleted from the order summary and there are no bundles left
      //reset the values of the following arrays
      setBundleClassic([]);
      setBundlePremium([]);
      setNumOfClassic(0);
      setNumOfPremium(0);
    }
  }, [isBundle]);

  const sandwiches = useRef(null);
  const drinks = useRef(null);
  const premium = useRef(null);
  const classic = useRef(null);
  const bundles = useRef(null);

  function handleClick(type) {
    if (type === "Bundles") {
      bundles.current?.scrollIntoView({
        behavior: "smooth",
      });
    } else if (type === "Premium Donuts") {
      premium.current?.scrollIntoView({
        behavior: "smooth",
      });
    } else if (type === "Classic Donuts") {
      classic.current?.scrollIntoView({
        behavior: "smooth",
      });
    } else if (type === "Drinks") {
      drinks.current?.scrollIntoView({
        behavior: "smooth",
      });
    } else if (type === "Bunwich") {
      sandwiches.current?.scrollIntoView({
        behavior: "smooth",
      });
    }
  }

  function handleItemClick({
    name: name,
    img: img,
    price: price,
    qty: qty,
    type: type,
  }) {
    console.log("item is clicked, isBundle is: " + isBundle);
    if (isBundle) {
      console.log("Current Bundle: " + currentBundle);
      if (type === "Premium" && !summaryBundles[currentBundle]?.premiumFull) {
        setBundlePremium((bP) => [...bP, { name: name, img: img }]);
        setNumOfPremium((numOfPremium) => numOfPremium + 1);
        if (numOfPremium == summaryBundles[currentBundle].numPremium - 1) {
          summaryBundles[currentBundle].premiumFull = true;
          console.log("Premium is full");
        }
        // console.log("number of Premium " + numOfPremium);
        //TO BE DELETED
        // const tempBundle = summaryBundles[currentBundle]; //get the current bundle
        // setBundlePremium(tempBundle.bundlePremium); //get the premium donuts in the current bundle
        // setBundlePremium([...bundlePremium, { name: name, img: img }]); //add the newly clicked premium donut to the premium
        // tempBundle.bundlePremium = bundlePremium; //update the premium donuts of the current bundle
        // addBundle(summaryBundles.splice(currentBundle, 1, tempBundle)); //replace the old bundle with the updated one
      } else if (
        type === "Classic" &&
        !summaryBundles[currentBundle].classicFull
      ) {
        setBundleClassic([...bundleClassic, { name: name, img: img }]);
        setNumOfClassic(numOfClassic + 1);
        if (numOfClassic == summaryBundles[currentBundle].numClassic - 1) {
          summaryBundles[currentBundle].classicFull = true;
          console.log("Classic is full");
        }
        //TO BE DELETED
        // const tempBundle = summaryBundles[currentBundle]; //get the current bundle
        // setBundleClassic(tempBundle.bundleClassic); //get the classic donuts in the current bundle
        // setBundleClassic([...bundleClassic, { name: name, img: img }]); //add the newly clicked classic donut to the premium
        // tempBundle.bundleClassic = bundleClassic; //update the classic donuts of the current bundle
        // addBundle(summaryBundles.splice(currentBundle, 1, tempBundle)); //replace the old bundle with the updated one
      }
      if (
        summaryBundles[currentBundle].premiumFull &&
        summaryBundles[currentBundle].classicFull
      ) {
        setIsBundle(false);
        console.log("Full Charjj");
      }
    } else {
      const existingDonut = summaryItems.find((donut) => donut.name === name);
      if (existingDonut != null) {
        const index = summaryItems.indexOf(existingDonut);
        summaryItems[index].qty = summaryItems[index].qty + 1;
        addItem([...summaryItems]);
      } else {
        addItem([
          ...summaryItems,
          { name: name, img: img, price: price, qty: qty },
        ]);
      }
    }
    //for debugging
    // summaryBundles[currentBundle].bundlePremium.map((item) =>
    //   console.log(item.name)
    // );
    // summaryBundles[currentBundle].bundleClassic.map((item) =>
    //   console.log(item.name)
    // );
    // console.log("LENGTH");
    // console.log("Premium" + summaryBundles[currentBundle].bundlePremium.length);
    // console.log("Classic" + summaryBundles[currentBundle].bundleClassic.length);
    //until here
  }

  function handleBundleClick({ name: name, img: img, price: price }) {
    //return if the current Bundle is not full
    if (isBundle) {
      return;
    }
    setCurrentBundle((cB) => cB + 1);
    let numClassic, numPremium;
    if (name === "FAMOUS") {
      numClassic = 6;
      numPremium = 6;
    } else if (name === "DELIGHTS") {
      numClassic = 9;
      numPremium = 3;
    } else if (name === "AWESOME") {
      numClassic = 8;
      numPremium = 8;
    } else if (name === "SUPREME") {
      numClassic = 15;
      numPremium = 3;
    } else if (name === "CLASSICS") {
      numClassic = 12;
      numPremium = 0;
    }
    addBundle([
      ...summaryBundles,
      {
        index: currentBundle,
        name: name,
        img: img,
        price: price,
        numClassic: numClassic,
        numPremium: numPremium,
        classicFull: false,
        premiumFull: false,
        bundleClassic: [],
        bundlePremium: [],
      },
    ]);
    setIsBundle(true);
  }

  return (
    <div className={styles.container}>
      <div className={styles.navAndProdContainer}>
        <div>
          <DonutNav handleClick={handleClick} />
        </div>
        <div className={styles.prodContainer}>
          <div className={styles.prodTypeName} ref={bundles}>
            <h1>Bundles</h1>
          </div>
          <div>
            <Bundles id="Bundles" handleBundleClick={handleBundleClick} />
          </div>
          <div className={styles.prodTypeName} ref={premium}>
            <h1>Premium</h1>
          </div>
          <div>
            <PremiumDonuts id="Premium" handleItemClick={handleItemClick} />
          </div>
          <div className={styles.prodTypeName} ref={classic}>
            <h1>Classic</h1>
          </div>
          <div>
            <ClassicDonuts id="Classic" handleItemClick={handleItemClick} />
          </div>
          <div className={styles.prodTypeName} ref={drinks}>
            <h1>Drinks</h1>
          </div>
          <div>
            <Drinks id="Drinks" handleItemClick={handleItemClick} />
          </div>
          <div className={styles.prodTypeName} ref={sandwiches}>
            <h1>Sandwiches</h1>
          </div>
          <div>
            <Sandwiches id="Bunwich" handleItemClick={handleItemClick} />
          </div>
        </div>
      </div>
      <div>
        <OrderSummaryContainer
          summaryItems={summaryItems}
          addItem={addItem}
          summaryBundles={summaryBundles}
          addBundle={addBundle}
          numOfClassic={numOfClassic}
          numOfPremium={numOfPremium}
          isBundle={isBundle}
          setIsBundle={setIsBundle}
          bundleClassic={bundleClassic}
          bundlePremium={bundlePremium}
          setCurrentBundle={setCurrentBundle}
          currentBundle={currentBundle}
          reset={reset}
        />
      </div>
    </div>
  );
}
