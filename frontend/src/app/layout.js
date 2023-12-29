import { Inter, Outfit } from "next/font/google";
import "./globals.css";

const outfit = Outfit({ subsets: ["latin"] });

export const metadata = {
    title: "Entertainment Web App",
    description:
        "Jake Godsall's solution to the Entertainment Web App challenge from Frontend Mentor.",
};

export default function RootLayout({ children }) {
    return (
        <html lang="en">
            <body className={outfit.className}>{children}</body>
        </html>
    );
}
