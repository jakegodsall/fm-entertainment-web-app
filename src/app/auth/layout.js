import Image from "next/image";

import appLogo from "../../../public/assets/logo.svg";

export default function AuthLayout({ children }) {
    return (
        <div className="mb-[17rem] flex flex-col items-center gap-[5.8rem] px-[2.4rem] py-[4.8rem]">
            <Image src={appLogo} alt="app logo" />
            {children}
        </div>
    );
}
