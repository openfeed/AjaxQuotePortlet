--
-- Host: localhost
-- Generation Time: Jul 27, 2013 at 10:26 PM



SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `openfeed`
--

-- --------------------------------------------------------

--
-- Table structure for table `equity_entity`
--

DROP TABLE IF EXISTS `equity_entity`;
CREATE TABLE IF NOT EXISTS `equity_entity` (
  `symbol` varchar(10) NOT NULL,
  `exchange` varchar(10) DEFAULT NULL,
  `company_name` varchar(100) DEFAULT NULL,
  `industry` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`symbol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `equity_entity`
--

INSERT INTO `equity_entity` (`symbol`, `exchange`, `company_name`, `industry`) VALUES
('.DJI', 'INDEXDJX', 'Dow Jones Industrial Average', 'All'),
('.INX', 'INDEXSP', 'S&P 500', 'All'),
('A', 'NYSE', 'Agilent Technologies', 'Information Technology'),
('AA', 'NYSE', 'Alcoa', 'Materials'),
('AAPL', 'NASDAQ', 'Apple', 'Information Technology'),
('ABD', 'NYSE', 'AmerisourceBergen', 'Health Care'),
('ABI', 'NYSE', 'Applied Biosystems Group', 'Health Care'),
('ABK', 'NYSE', 'Ambac Financial Group', 'Financials'),
('ABT', 'NYSE', 'Abbott Laboratories', 'Health Care'),
('ACAS', 'NASDAQ', 'American Capital Strategies', 'Financials'),
('ACE', 'NYSE', 'ACE', 'Financials'),
('ACS', 'NYSE', 'Affiliated Computer Services', 'Information Technology'),
('ADBE', 'NASDAQ', 'Adobe Systems', 'Information Technology'),
('ADI', 'NYSE', 'Analog Devices', 'Information Technology'),
('ADP', 'NYSE', 'Automatic Data Processing', 'Information Technology'),
('ADSK', 'NASDAQ', 'Autodesk', 'Information Technology'),
('AEE', 'NYSE', 'Ameren', 'Utilities'),
('AEP', 'NYSE', 'American Electric Power', 'Utilities'),
('AES', 'NYSE', 'AES', 'Utilities'),
('AET', 'NYSE', 'Aetna', 'Health Care'),
('AFL', 'NYSE', 'AFLAC', 'Financials'),
('AGN', 'NYSE', 'Allergan', 'Health Care'),
('AIG', 'NYSE', 'American International Group', 'Financials'),
('AIV', 'NYSE', 'Apartment Investment and Management', 'Financials'),
('AIZ', 'NYSE', 'Assurant', 'Financials'),
('AKAM', 'NASDAQ', 'Akamai Technologies', 'Information Technology'),
('ALL', 'NYSE', 'Allstate', 'Financials'),
('ALTR', 'NASDAQ', 'Altera', 'Information Technology'),
('AMAT', 'NASDAQ', 'Applied Materials', 'Information Technology'),
('AMD', 'NYSE', 'Advanced Micro Devices', 'Information Technology'),
('AMGN', 'NASDAQ', 'Amgen', 'Health Care'),
('AMP', 'NYSE', 'Ameriprise Financial', 'Financials'),
('AMT', 'NYSE', 'American Tower', 'Telecommunications Services'),
('AMZN', 'NASDAQ', 'Amazon.com', 'Consumer Discretionary'),
('AN', 'NYSE', 'AutoNation', 'Consumer Discretionary'),
('ANF', 'NYSE', 'Abercrombie & Fitch', 'Consumer Discretionary'),
('AOC', 'NYSE', 'Aon', 'Financials'),
('APA', 'NYSE', 'Apache', 'Energy'),
('APC', 'NYSE', 'Anadarko Petroleum', 'Energy'),
('APD', 'NYSE', 'Air Products & Chemicals', 'Materials'),
('APOL', 'NASDAQ', 'Apollo Group', 'Consumer Discretionary'),
('ASD', 'NYSE', 'American Standard', 'Industrials'),
('ASH', 'NYSE', 'Ashland', 'Materials'),
('ATI', 'NYSE', 'Allegheny Technologies', 'Materials'),
('AVB', 'NYSE', 'AvalonBay Communities', 'Financials'),
('AVP', 'NYSE', 'Avon Products', 'Consumer Staples'),
('AVY', 'NYSE', 'Avery Dennison', 'Industrials'),
('AW', 'NYSE', 'Allied Waste Industries', 'Industrials'),
('AXP', 'NYSE', 'American Express', 'Financials'),
('AYE', 'NYSE', 'Allegheny Energy', 'Utilities'),
('AZO', 'NYSE', 'AutoZone', 'Consumer Discretionary'),
('BA', 'NYSE', 'Boeing', 'Industrials'),
('BAC', 'NYSE', 'Bank of America', 'Financials'),
('BAX', 'NYSE', 'Baxter International', 'Health Care'),
('BBBY', 'NASDAQ', 'Bed Bath & Beyond', 'Consumer Discretionary'),
('BBT', 'NYSE', 'BB&T', 'Financials'),
('BBY', 'NYSE', 'Best Buy Co.', 'Consumer Discretionary'),
('BC', 'NYSE', 'Brunswick', 'Consumer Discretionary'),
('BCR', 'NYSE', 'C.R. Bard', 'Health Care'),
('BDK', 'NYSE', 'Black & Decker', 'Consumer Discretionary'),
('BDX', 'NYSE', 'Becton, Dickinson and Co.', 'Health Care'),
('BEN', 'NYSE', 'Franklin Resources', 'Financials'),
('BF.B', 'NYSE', 'Brown-Forman', 'Consumer Staples'),
('BHI', 'NYSE', 'Baker Hughes', 'Energy'),
('BIG', 'NYSE', 'Big Lots', 'Consumer Discretionary'),
('BIIB', 'NASDAQ', 'Biogen Idec', 'Health Care'),
('BJS', 'NYSE', 'BJ Services', 'Energy'),
('BK', 'NYSE', 'Bank of New York Mellon Corp.', 'Financials'),
('BLL', 'NYSE', 'Ball', 'Materials'),
('BMC', 'NYSE', 'BMC Software', 'Information Technology'),
('BMS', 'NYSE', 'Bemis Company', 'Materials'),
('BMY', 'NYSE', 'Bristol Myers Squibb', 'Health Care'),
('BNI', 'NYSE', 'Burlington Northern Santa Fe', 'Industrials'),
('BRCM', 'NASDAQ', 'Broadcom', 'Information Technology'),
('BRL', 'NYSE', 'Barr Pharmaceuticals', 'Health Care'),
('BSC', 'NYSE', 'Bear Stearns', 'Financials'),
('BSX', 'NYSE', 'Boston Scientific', 'Health Care'),
('BTU', 'NYSE', 'Peabody Energy', 'Energy'),
('BUD', 'NYSE', 'Anheuser-Busch', 'Consumer Staples'),
('BXP', 'NYSE', 'Boston Properties', 'Financials'),
('C', 'NYSE', 'Citigroup', 'Financials'),
('CA', 'NYSE', 'CA', 'Information Technology'),
('CAG', 'NYSE', 'ConAgra Foods', 'Consumer Staples'),
('CAH', 'NYSE', 'Cardinal Health', 'Health Care'),
('CAT', 'NYSE', 'Caterpillar', 'Industrials'),
('CB', 'NYSE', 'Chubb', 'Financials'),
('CBE', 'NYSE', 'Cooper Industries', 'Industrials'),
('CBG', 'NYSE', 'CB Richard Ellis Group', 'Financials'),
('CBH', 'NYSE', 'Commerce Bancorp', 'Financials'),
('CBS', 'NYSE', 'CBS', 'Consumer Discretionary'),
('CC', 'NYSE', 'Circuit City Stores', 'Consumer Discretionary'),
('CCE', 'NYSE', 'Coca-Cola Enterprises', 'Consumer Staples'),
('CCL', 'NYSE', 'Carnival', 'Consumer Discretionary'),
('CCU', 'NYSE', 'Clear Channel Communications', 'Consumer Discretionary'),
('CELG', 'NASDAQ', 'Celgene', 'Health Care'),
('CFC', 'NYSE', 'Countrywide Financial', 'Financials'),
('CHK', 'NYSE', 'Chesapeake Energy', 'Energy'),
('CHRW', 'NASDAQ', 'C.H. Robinson Worldwide', 'Industrials'),
('CI', 'NYSE', 'CIGNA', 'Health Care'),
('CIEN', 'NASDAQ', 'Ciena', 'Information Technology'),
('CINF', 'NASDAQ', 'Cincinnati Financial', 'Financials'),
('CIT', 'NYSE', 'CIT Group', 'Financials'),
('CL', 'NYSE', 'Colgate-Palmolive', 'Consumer Staples'),
('CLX', 'NYSE', 'Clorox', 'Consumer Staples'),
('CMA', 'NYSE', 'Comerica', 'Financials'),
('CMCSA', 'NASDAQ', 'Comcast', 'Consumer Discretionary'),
('CME', 'NYSE', 'CME Group', 'Financials'),
('CMI', 'NYSE', 'Cummins', 'Industrials'),
('CMS', 'NYSE', 'CMS Energy', 'Utilities'),
('CNP', 'NYSE', 'CenterPoint Energy', 'Utilities'),
('CNX', 'NYSE', 'CONSOL Energy', 'Energy'),
('COF', 'NYSE', 'Capital One Financial', 'Financials'),
('COH', 'NYSE', 'Coach', 'Consumer Discretionary'),
('COL', 'NYSE', 'Rockwell Collins', 'Industrials'),
('COP', 'NYSE', 'ConocoPhillips', 'Energy'),
('COST', 'NASDAQ', 'Costco', 'Consumer Staples'),
('COV', 'NYSE', 'Covidien', 'Health Care'),
('CPB', 'NYSE', 'Campbell Soup', 'Consumer Staples'),
('CPWR', 'NYSE', 'Compuware', 'Information Technology'),
('CSC', 'NYSE', 'Computer Sciences', 'Information Technology'),
('CSCO', 'NASDAQ', 'Cisco Systems', 'Information Technology'),
('CSX', 'NYSE', 'CSX', 'Industrials'),
('CTAS', 'NASDAQ', 'Cintas', 'Industrials'),
('CTL', 'NYSE', 'CenturyTel', 'Telecommunications Services'),
('CTSH', 'NASDAQ', 'Cognizant Technology Solutions', 'Information Technology'),
('CTX', 'NYSE', 'Centex', 'Consumer Discretionary'),
('CTXS', 'NASDAQ', 'Citrix Systems', 'Information Technology'),
('CVG', 'NYSE', 'Convergys', 'Information Technology'),
('CVH', 'NYSE', 'Coventry Health Care', 'Health Care'),
('CVS', 'NYSE', 'CVS Caremark', 'Consumer Staples'),
('CVX', 'NYSE', 'Chevron', 'Energy'),
('CZN', 'NYSE', 'Citizens Communications', 'Telecommunications Services'),
('D', 'NYSE', 'Dominion Resources', 'Utilities'),
('DD', 'NYSE', 'DuPont', 'Materials'),
('DDR', 'NYSE', 'Developers Diversified Realty', 'Financials'),
('DDS', 'NYSE', 'Dillard', 'Consumer Discretionary'),
('DE', 'NYSE', 'Deere & Company', 'Industrials'),
('DELL', 'NASDAQ', 'Dell', 'Information Technology'),
('DF', 'NYSE', 'Dean Foods', 'Consumer Staples'),
('DFS', 'NYSE', 'Discover Financial Services', 'Financials'),
('DGX', 'NYSE', 'Quest Diagnostics', 'Health Care'),
('DHI', 'NYSE', 'D.R. Horton', 'Consumer Discretionary'),
('DHR', 'NYSE', 'Danaher', 'Industrials'),
('DIS', 'NYSE', 'Walt Disney', 'Consumer Discretionary'),
('DJ', 'NYSE', 'Dow Jones & Company', 'Consumer Discretionary'),
('DOV', 'NYSE', 'Dover', 'Industrials'),
('DOW', 'NYSE', 'Dow Chemical', 'Materials'),
('DRI', 'NYSE', 'Darden Restaurants', 'Consumer Discretionary'),
('DTE', 'NYSE', 'DTE Energy', 'Utilities'),
('DTV', 'NYSE', 'DIRECTV Group', 'Consumer Discretionary'),
('DUK', 'NYSE', 'Duke Energy', 'Utilities'),
('DVN', 'NYSE', 'Devon Energy', 'Energy'),
('DYN', 'NYSE', 'Dynegy', 'Utilities'),
('EBAY', 'NASDAQ', 'eBay', 'Information Technology'),
('ECL', 'NYSE', 'Ecolab', 'Materials'),
('ED', 'NYSE', 'Consolidated Edison', 'Utilities'),
('EDS', 'NYSE', 'Electronic Data Systems', 'Information Technology'),
('EFX', 'NYSE', 'Equifax', 'Industrials'),
('EIX', 'NYSE', 'Edison International', 'Utilities'),
('EK', 'NYSE', 'Eastman Kodak', 'Consumer Discretionary'),
('EL', 'NYSE', 'Estee Lauder', 'Consumer Staples'),
('EMC', 'NYSE', 'EMC', 'Information Technology'),
('EMN', 'NYSE', 'Eastman Chemical', 'Materials'),
('EMR', 'NYSE', 'Emerson Electric', 'Industrials'),
('EOG', 'NYSE', 'EOG Resources', 'Energy'),
('EP', 'NYSE', 'El Paso', 'Energy'),
('EQ', 'NYSE', 'Embarq', 'Telecommunications Services'),
('EQR', 'NYSE', 'Equity Residential', 'Financials'),
('ERTS', 'NYSE', 'Electronic Arts', 'Information Technology'),
('ESRX', 'NASDAQ', 'Express Scripts', 'Health Care'),
('ESV', 'NYSE', 'ENSCO International', 'Energy'),
('ETFC', 'NASDAQ', 'E TRADE Financial', 'Financials'),
('ETN', 'NYSE', 'Eaton', 'Industrials'),
('ETR', 'NYSE', 'Entergy', 'Utilities'),
('EXC', 'NYSE', 'Exelon', 'Utilities'),
('EXPD', 'NASDAQ', 'Expeditors International', 'Industrials'),
('EXPE', 'NASDAQ', 'Expedia', 'Consumer Discretionary'),
('F', 'NYSE', 'Ford Motor', 'Consumer Discretionary'),
('FCX', 'NYSE', 'Freeport-McMoRan Copper & Gold', 'Materials'),
('FDO', 'NYSE', 'Family Dollar Stores', 'Consumer Discretionary'),
('FDX', 'NYSE', 'FedEx', 'Industrials'),
('FE', 'NYSE', 'FirstEnergy', 'Utilities'),
('FHN', 'NYSE', 'First Horizon National', 'Financials'),
('FII', 'NYSE', 'Federated Investors', 'Financials'),
('FIS', 'NYSE', 'Fidelity National Information Services', 'Information Technology'),
('FISV', 'NASDAQ', 'FIserv', 'Information Technology'),
('FITB', 'NASDAQ', 'Fifth Third Bancorp', 'Financials'),
('FLR', 'NYSE', 'Fluor', 'Industrials'),
('FNM', 'NYSE', 'Fannie Mae', 'Financials'),
('FO', 'NYSE', 'Fortune Brands', 'Consumer Discretionary'),
('FPL', 'NYSE', 'FPL Group', 'Utilities'),
('FRE', 'NYSE', 'Freddie Mac', 'Financials'),
('FRX', 'NYSE', 'Forest Laboratories', 'Health Care'),
('GAP', 'NYSE', 'Gap', 'Consumer Discretionary'),
('GAS', 'NYSE', 'Nicor', 'Utilities'),
('GCI', 'NYSE', 'Gannett', 'Consumer Discretionary'),
('GD', 'NYSE', 'General Dynamics', 'Industrials'),
('GE', 'NYSE', 'General Electric', 'Industrials'),
('GENZ', 'NASDAQ', 'Genzyme', 'Health Care'),
('GGP', 'NYSE', 'Genl Growth Properties', 'Financials'),
('GILD', 'NASDAQ', 'Gilead Sciences', 'Health Care'),
('GIS', 'NYSE', 'General Mills', 'Consumer Staples'),
('GLW', 'NYSE', 'Corning', 'Information Technology'),
('GM', 'NYSE', 'General Motors', 'Consumer Discretionary'),
('GNW', 'NYSE', 'Genworth Financial', 'Financials'),
('GOOG', 'NASDAQ', 'Google', 'Information Technology'),
('GPC', 'NYSE', 'Genuine Parts', 'Consumer Discretionary'),
('GR', 'NYSE', 'Goodrich Corporation', 'Industrials'),
('GS', 'NYSE', 'Goldman Sachs Group', 'Financials'),
('GT', 'NYSE', 'Goodyear Tire & Rubber', 'Consumer Discretionary'),
('GWW', 'NYSE', 'W.W. Grainger', 'Industrials'),
('HAL', 'NYSE', 'Halliburton', 'Energy'),
('HAR', 'NYSE', 'Harman International Industries', 'Consumer Discretionary'),
('HAS', 'NYSE', 'Hasbro', 'Consumer Discretionary'),
('HBAN', 'NYSE', 'Huntington Bancshares', 'Financials'),
('HCBK', 'NYSE', 'Hudson City Bancorp', 'Financials'),
('HD', 'NYSE', 'Home Depot', 'Consumer Discretionary'),
('HES', 'NYSE', 'Hess', 'Energy'),
('HET', 'NYSE', 'Harrah''s Entertainment', 'Consumer Discretionary'),
('HIG', 'NYSE', 'Hartford Financial Services', 'Financials'),
('HNZ', 'NYSE', 'H.J. Heinz', 'Consumer Staples'),
('HOG', 'NYSE', 'Harley-Davidson', 'Consumer Discretionary'),
('HON', 'NYSE', 'Honeywell', 'Industrials'),
('HOT', 'NYSE', 'Starwood Hotels & Resorts', 'Consumer Discretionary'),
('HPC', 'NYSE', 'Hercules', 'Materials'),
('HPQ', 'NYSE', 'Hewlett-Packard', 'Information Technology'),
('HRB', 'NYSE', 'H&R Block', 'Consumer Discretionary'),
('HSP', 'NYSE', 'Hospira', 'Health Care'),
('HST', 'NYSE', 'Host Hotels & Resorts', 'Financials'),
('HSY', 'NYSE', 'Hershey', 'Consumer Staples'),
('HUM', 'NYSE', 'Humana', 'Health Care'),
('IACI', 'NYSE', 'IAC InterActiveCorp', 'Consumer Discretionary'),
('IBM', 'NYSE', 'IBM', 'Information Technology'),
('ICE', 'NYSE', 'IntercontinentalExchange', 'Financials'),
('IFF', 'NYSE', 'International Flavors & Fragrances', 'Materials'),
('IGT', 'NYSE', 'International Game Technology', 'Consumer Discretionary'),
('INTC', 'NASDAQ', 'Intel', 'Information Technology'),
('INTU', 'NASDAQ', 'Intuit', 'Information Technology'),
('IP', 'NYSE', 'International Paper', 'Materials'),
('IPG', 'NYSE', 'Interpublic Group', 'Consumer Discretionary'),
('IR', 'NYSE', 'Ingersoll-Rand', 'Industrials'),
('ITT', 'NYSE', 'ITT Corporation', 'Industrials'),
('ITW', 'NYSE', 'Illinois Tool Works', 'Industrials'),
('JAVAD', 'NASDAQ', 'Sun Microsystems', 'Information Technology'),
('JBL', 'NYSE', 'Jabil Circuit', 'Information Technology'),
('JCI', 'NYSE', 'Johnson Controls', 'Consumer Discretionary'),
('JCP', 'NYSE', 'J.C. Penney', 'Consumer Discretionary'),
('JDSU', 'NYSE', 'JDS Uniphase', 'Information Technology'),
('JEC', 'NYSE', 'Jacobs Engineering Group', 'Industrials'),
('JNJ', 'NYSE', 'Johnson & Johnson', 'Health Care'),
('JNPR', 'NYSE', 'Juniper Networks', 'Information Technology'),
('JNS', 'NYSE', 'Janus Capital Group', 'Financials'),
('JNY', 'NYSE', 'Jones Apparel Group', 'Consumer Discretionary'),
('JPM', 'NYSE', 'JPMorgan Chase', 'Financials'),
('JWN', 'NYSE', 'Nordstrom', 'Consumer Discretionary'),
('K', 'NYSE', 'Kellogg', 'Consumer Staples'),
('KBH', 'NYSE', 'KB Home', 'Consumer Discretionary'),
('KEY', 'NYSE', 'KeyCorp', 'Financials'),
('KFT', 'NYSE', 'Kraft Foods', 'Consumer Staples'),
('KG', 'NYSE', 'King Pharmaceuticals', 'Health Care'),
('KIM', 'NYSE', 'Kimco Realty', 'Financials'),
('KLAC', 'NASDAQ', 'KLA-Tencor', 'Information Technology'),
('KMB', 'NYSE', 'Kimberly-Clark', 'Consumer Staples'),
('KO', 'NYSE', 'Coca-Cola', 'Consumer Staples'),
('KR', 'NYSE', 'Kroger', 'Consumer Staples'),
('KSS', 'NYSE', 'Kohl''s', 'Consumer Discretionary'),
('LEG', 'NYSE', 'Leggett & Platt', 'Consumer Discretionary'),
('LEH', 'NYSE', 'Lehman Brothers Holdings', 'Financials'),
('LEN', 'NYSE', 'Lennar', 'Consumer Discretionary'),
('LH', 'NYSE', 'Laboratory Corp. of America Holdings', 'Health Care'),
('LIZ', 'NYSE', 'Liz Claiborne', 'Consumer Discretionary'),
('LLL', 'NYSE', 'L-3 Communications Holdings', 'Industrials'),
('LLTC', 'NASDAQ', 'Linear Technology', 'Information Technology'),
('LLY', 'NYSE', 'Eli Lilly & Co.', 'Health Care'),
('LM', 'NYSE', 'Legg Mason', 'Financials'),
('LMT', 'NYSE', 'Lockheed Martin', 'Industrials'),
('LNC', 'NYSE', 'Lincoln National', 'Financials'),
('LOW', 'NYSE', 'Lowe''s Companies', 'Consumer Discretionary'),
('LSI', 'NYSE', 'LSI', 'Information Technology'),
('LTD', 'NYSE', 'Limited Brands', 'Consumer Discretionary'),
('LTR', 'NYSE', 'Loews', 'Financials'),
('LUK', 'NYSE', 'Leucadia National', 'Financials'),
('LUV', 'NYSE', 'Southwest Airlines', 'Industrials'),
('LXK', 'NYSE', 'Lexmark International', 'Information Technology'),
('M', 'NYSE', 'Macy''s', 'Consumer Discretionary'),
('MAR', 'NYSE', 'Marriott International', 'Consumer Discretionary'),
('MAS', 'NYSE', 'Masco', 'Industrials'),
('MAT', 'NYSE', 'Mattel', 'Consumer Discretionary'),
('MBI', 'NYSE', 'MBIA', 'Financials'),
('MCD', 'NYSE', 'McDonald''s', 'Consumer Discretionary'),
('MCHP', 'NYSE', 'Microchip Technology', 'Information Technology'),
('MCK', 'NYSE', 'McKesson', 'Health Care'),
('MCO', 'NYSE', 'Moody''s', 'Financials'),
('MDP', 'NYSE', 'Meredith', 'Consumer Discretionary'),
('MDT', 'NYSE', 'Medtronic', 'Health Care'),
('MER', 'NYSE', 'Merrill Lynch', 'Financials'),
('MET', 'NYSE', 'MetLife', 'Financials'),
('MHP', 'NYSE', 'McGraw-Hill', 'Consumer Discretionary'),
('MHS', 'NYSE', 'Medco Health Solutions', 'Health Care'),
('MI', 'NYSE', 'Marshall & Ilsley', 'Financials'),
('MIL', 'NYSE', 'Millipore', 'Health Care'),
('MKC', 'NYSE', 'McCormick & Company', 'Consumer Staples'),
('MMC', 'NYSE', 'Marsh & McLennan', 'Financials'),
('MMM', 'NYSE', '3M', 'Industrials'),
('MNST', 'NASDAQ', 'Monster Worldwide', 'Industrials'),
('MO', 'NYSE', 'Altria Group', 'Consumer Staples'),
('MOLX', 'NYSE', 'Molex', 'Information Technology'),
('MON', 'NYSE', 'Monsanto', 'Materials'),
('MOT', 'NYSE', 'Motorola', 'Information Technology'),
('MRK', 'NYSE', 'Merck', 'Health Care'),
('MRO', 'NYSE', 'Marathon Oil', 'Energy'),
('MS', 'NYSE', 'Morgan Stanley', 'Financials'),
('MSFT', 'NASDAQ', 'Microsoft', 'Information Technology'),
('MTB', 'NYSE', 'M&T Bank', 'Financials'),
('MTG', 'NYSE', 'MGIC Investment', 'Financials'),
('MTW', 'NYSE', 'Manitowoc', 'Industrials'),
('MU', 'NYSE', 'Micron Technology', 'Information Technology'),
('MUR', 'NYSE', 'Murphy Oil', 'Energy'),
('MWV', 'NYSE', 'MeadWestvaco', 'Materials'),
('MYL', 'NYSE', 'Mylan', 'Health Care'),
('NBL', 'NYSE', 'Noble Energy', 'Energy'),
('NBR', 'NYSE', 'Nabors Industries', 'Energy'),
('NCC', 'NYSE', 'National City', 'Financials'),
('NE', 'NYSE', 'Noble', 'Energy'),
('NEM', 'NYSE', 'Newmont Mining', 'Materials'),
('NI', 'NYSE', 'NiSource', 'Utilities'),
('NKE', 'NYSE', 'NIKE', 'Consumer Discretionary'),
('NOC', 'NYSE', 'Northrop Grumman', 'Industrials'),
('NOV', 'NYSE', 'National Oilwell Varco', 'Energy'),
('NOVL', 'NYSE', 'Novell', 'Information Technology'),
('NSM', 'NYSE', 'National Semiconductor', 'Information Technology'),
('NTAP', 'NASDAQ', 'Network Appliance', 'Information Technology'),
('NTRS', 'NASDAQ', 'Northern Trust', 'Financials'),
('NUE', 'NYSE', 'Nucor', 'Materials'),
('NVDA', 'NASDAQ', 'NVIDIA', 'Information Technology'),
('NVLS', 'NASDAQ', 'Novellus Systems', 'Information Technology'),
('NWL', 'NYSE', 'Newell Rubbermaid', 'Consumer Discretionary'),
('NWS.A', 'NYSE', 'News Corporation', 'Consumer Discretionary'),
('NYT', 'NYSE', 'New York Times', 'Consumer Discretionary'),
('NYX', 'NYSE', 'NYSE Euronext', 'Financials'),
('ODP', 'NYSE', 'Office Depot', 'Consumer Discretionary'),
('OMC', 'NYSE', 'Omnicom Group', 'Consumer Discretionary'),
('OMX', 'NYSE', 'OfficeMax', 'Consumer Discretionary'),
('ORCL', 'NASDAQ', 'Oracle', 'Information Technology'),
('OXY', 'NYSE', 'Occidental Petroleum', 'Energy'),
('PAYX', 'NASDAQ', 'Paychex', 'Information Technology'),
('PBG', 'NYSE', 'Pepsi Bottling Group', 'Consumer Staples'),
('PBI', 'NYSE', 'Pitney Bowes', 'Industrials'),
('PCAR', 'NASDAQ', 'PACCAR', 'Industrials'),
('PCG', 'NYSE', 'PG&E', 'Utilities'),
('PCL', 'NYSE', 'Plum Creek Timber', 'Financials'),
('PCP', 'NYSE', 'Precision Castparts', 'Industrials'),
('PDCO', 'NASDAQ', 'Patterson Companies', 'Health Care'),
('PEG', 'NYSE', 'Public Service Enterprise Group', 'Utilities'),
('PEP', 'NYSE', 'PepsiCo', 'Consumer Staples'),
('PFE', 'NYSE', 'Pfizer', 'Health Care'),
('PFG', 'NYSE', 'Principal Financial Group', 'Financials'),
('PG', 'NYSE', 'Procter & Gamble', 'Consumer Staples'),
('PGN', 'NYSE', 'Progress Energy', 'Utilities'),
('PGR', 'NYSE', 'Progressive', 'Financials'),
('PH', 'NYSE', 'Parker-Hannifin', 'Industrials'),
('PHM', 'NYSE', 'Pulte Homes', 'Consumer Discretionary'),
('PKI', 'NYSE', 'PerkinElmer', 'Health Care'),
('PLD', 'NYSE', 'ProLogis', 'Financials'),
('PLL', 'NYSE', 'Pall', 'Industrials'),
('PNC', 'NYSE', 'PNC Financial Services', 'Financials'),
('PNW', 'NYSE', 'Pinnacle West Capital', 'Utilities'),
('PPG', 'NYSE', 'PPG Industries', 'Materials'),
('PPL', 'NYSE', 'PPL Corporation', 'Utilities'),
('PRU', 'NYSE', 'Prudential Financial', 'Financials'),
('PSA', 'NYSE', 'Public Storage', 'Financials'),
('PTV', 'NYSE', 'Pactiv', 'Materials'),
('PX', 'NYSE', 'Praxair', 'Materials'),
('Q', 'NYSE', 'Qwest Communications', 'Telecommunications Services'),
('QCOM', 'NASDAQ', 'QUALCOMM', 'Information Technology'),
('QLGC', 'NASDAQ', 'QLogic', 'Information Technology'),
('R', 'NYSE', 'Ryder System', 'Industrials'),
('RAI', 'NYSE', 'Reynolds American', 'Consumer Staples'),
('RDC', 'NYSE', 'Rowan Companies', 'Energy'),
('RF', 'NYSE', 'Regions Financial', 'Financials'),
('RHI', 'NYSE', 'Robert Half International', 'Industrials'),
('RIG', 'NYSE', 'Transocean', 'Energy'),
('RL', 'NYSE', 'Polo Ralph Lauren', 'Consumer Discretionary'),
('ROH', 'NYSE', 'Rohm and Haas', 'Materials'),
('ROK', 'NYSE', 'Rockwell Automation', 'Industrials'),
('RRD', 'NYSE', 'R.R. Donnelley & Sons', 'Industrials'),
('RSH', 'NYSE', 'RadioShack', 'Consumer Discretionary'),
('RTN', 'NYSE', 'Raytheon', 'Industrials'),
('RX', 'NYSE', 'IMS Health', 'Health Care'),
('S', 'NYSE', 'Sprint Nextel', 'Telecommunications Services'),
('SAF', 'NYSE', 'SAFECO', 'Financials'),
('SBUX', 'NASDAQ', 'Starbucks', 'Consumer Discretionary'),
('SCHW', 'NASDAQ', 'Charles Schwab', 'Financials'),
('SE', 'NYSE', 'Spectra Energy', 'Energy'),
('SEE', 'NYSE', 'Sealed Air', 'Materials'),
('SGP', 'NYSE', 'Schering-Plough', 'Health Care'),
('SHLD', 'NASDAQ', 'Sears Holdings', 'Consumer Discretionary'),
('SHW', 'NYSE', 'Sherwin-Williams', 'Consumer Discretionary'),
('SIAL', 'NASDAQ', 'Sigma-Aldrich', 'Materials'),
('SII', 'NYSE', 'Smith International', 'Energy'),
('SLB', 'NYSE', 'Schlumberger', 'Energy'),
('SLE', 'NYSE', 'Sara Lee', 'Consumer Staples'),
('SLM', 'NYSE', 'SLM Corporation', 'Financials'),
('SNA', 'NYSE', 'Snap-On', 'Consumer Discretionary'),
('SNDK', 'NASDAQ', 'SanDisk', 'Information Technology'),
('SNV', 'NYSE', 'Synovus Financial', 'Financials'),
('SO', 'NYSE', 'Southern', 'Utilities'),
('SOV', 'NYSE', 'Sovereign Bancorp', 'Financials'),
('SPG', 'NYSE', 'Simon Property Group', 'Financials'),
('SPLS', 'NASDAQ', 'Staples', 'Consumer Discretionary'),
('SRE', 'NYSE', 'Sempra Energy', 'Utilities'),
('SSP', 'NYSE', 'E.W. Scripps', 'Consumer Discretionary'),
('STI', 'NYSE', 'SunTrust Banks', 'Financials'),
('STJ', 'NYSE', 'St. Jude Medical', 'Health Care'),
('STR', 'NYSE', 'Questar', 'Utilities'),
('STT', 'NYSE', 'State Street', 'Financials'),
('STZ', 'NYSE', 'Constellation Brands', 'Consumer Staples'),
('SUN', 'NYSE', 'Sunoco', 'Energy'),
('SVU', 'NYSE', 'Supervalu', 'Consumer Staples'),
('SWK', 'NYSE', 'Stanley Works', 'Consumer Discretionary'),
('SWY', 'NYSE', 'Safeway', 'Consumer Staples'),
('SYK', 'NYSE', 'Stryker', 'Health Care'),
('SYMC', 'NASDAQ', 'Symantec', 'Information Technology'),
('SYY', 'NYSE', 'Sysco', 'Consumer Staples'),
('T', 'NYSE', 'AT&T', 'Telecommunication Services'),
('TAP', 'NYSE', 'Molson Coors Brewing', 'Consumer Staples'),
('TDC', 'NYSE', 'Teradata', 'Information Technology'),
('TE', 'NYSE', 'TECO Energy', 'Utilities'),
('TEG', 'NYSE', 'Integrys Energy Group', 'Utilities'),
('TEL', 'NYSE', 'Tyco Electronics', 'Information Technology'),
('TER', 'NYSE', 'Teradyne', 'Information Technology'),
('TEX', 'NYSE', 'Terex', 'Industrials'),
('TGT', 'NYSE', 'Target', 'Consumer Discretionary'),
('THC', 'NYSE', 'Tenet Healthcare', 'Health Care'),
('TIE', 'NYSE', 'Titanium Metals', 'Materials'),
('TIF', 'NYSE', 'Tiffany', 'Consumer Discretionary'),
('TIN', 'NYSE', 'Temple-Inland', 'Materials'),
('TJX', 'NYSE', 'TJX Companies', 'Consumer Discretionary'),
('TLAB', 'NASDAQ', 'Tellabs', 'Information Technology'),
('TMK', 'NYSE', 'Torchmark', 'Financials'),
('TMO', 'NYSE', 'Thermo Fisher Scientific', 'Health Care'),
('TRB', 'NYSE', 'Tribune', 'Consumer Discretionary'),
('TROW', 'NASDAQ', 'T. Rowe Price Group', 'Financials'),
('TRV', 'NYSE', 'The Travelers Companies', 'Financials'),
('TSN', 'NYSE', 'Tyson Foods', 'Consumer Staples'),
('TSO', 'NYSE', 'Tesoro Petroleum', 'Energy'),
('TWX', 'NYSE', 'Time Warner', 'Consumer Discretionary'),
('TXN', 'NYSE', 'Texas Instruments', 'Information Technology'),
('TXT', 'NYSE', 'Textron', 'Industrials'),
('TYC', 'NYSE', 'Tyco International', 'Industrials'),
('UIS', 'NYSE', 'Unisys', 'Information Technology'),
('UNH', 'NYSE', 'United Health Group', 'Health Care'),
('UNM', 'NYSE', 'Unum Group', 'Financials'),
('UNP', 'NYSE', 'Union Pacific', 'Industrials'),
('UPS', 'NYSE', 'United Parcel Service', 'Industrials'),
('USB', 'NYSE', 'U.S. Bancorp', 'Financials'),
('UST', 'NYSE', 'UST', 'Consumer Staples'),
('UTX', 'NYSE', 'United Technologies', 'Industrials'),
('VAR', 'NYSE', 'Varian Medical Systems', 'Health Care'),
('VFC', 'NYSE', 'V.F. Corporation', 'Consumer Discretionary'),
('VIA.B', 'NYSE', 'Viacom', 'Consumer Discretionary'),
('VLO', 'NYSE', 'Valero Energy', 'Energy'),
('VMC', 'NYSE', 'Vulcan Materials', 'Materials'),
('VNO', 'NYSE', 'Vornado Realty Trust', 'Financials'),
('VRSN', 'NASDAQ', 'Verisign', 'Information Technology'),
('VZ', 'NYSE', 'Verizon Communications', 'Telecommunications Services'),
('WAG', 'NYSE', 'Walgreen', 'Consumer Staples'),
('WAT', 'NYSE', 'Waters Corporation', 'Health Care'),
('WB', 'NYSE', 'Wachovia', 'Financials'),
('WEN', 'NYSE', 'Wendy''s International', 'Consumer Discretionary'),
('WFC', 'NYSE', 'Wells Fargo', 'Financials'),
('WFMI', 'NASDAQ', 'Whole Foods Market', 'Consumer Staples'),
('WFR', 'NYSE', 'MEMC Electronic Materials', 'Information Technology'),
('WFT', 'NYSE', 'Weatherford International', 'Energy'),
('WHR', 'NYSE', 'Whirlpool', 'Consumer Discretionary'),
('WIN', 'NYSE', 'Windstream', 'Telecommunications Services'),
('WLP', 'NYSE', 'WellPoint', 'Health Care'),
('WM', 'NYSE', 'Washington Mutual', 'Financials'),
('WMB', 'NYSE', 'Williams Companies', 'Energy'),
('WMI', 'NYSE', 'Waste Management', 'Industrials'),
('WMT', 'NYSE', 'Wal-Mart', 'Consumer Staples'),
('WPI', 'NYSE', 'Watson Pharmaceuticals', 'Health Care'),
('WU', 'NYSE', 'Western Union', 'Information Technology'),
('WWY', 'NYSE', 'Wm. Wrigley Jr.', 'Consumer Staples'),
('WY', 'NYSE', 'Weyerhaeuser', 'Materials'),
('WYE', 'NYSE', 'Wyeth', 'Health Care'),
('WYN', 'NYSE', 'Wyndham Worldwide', 'Consumer Discretionary'),
('X', 'NYSE', 'United States Steel', 'Materials'),
('XEL', 'NYSE', 'Xcel Energy', 'Utilities'),
('XL', 'NYSE', 'XL Capital', 'Financials'),
('XLNX', 'NYSE', 'Xilinx', 'Information Technology'),
('XOM', 'NYSE', 'Exxon Mobil', 'Energy'),
('XRX', 'NYSE', 'Xerox', 'Information Technology'),
('XTO', 'NYSE', 'XTO Energy', 'Energy'),
('YHOO', 'NASDAQ', 'Yahoo', 'Information Technology'),
('YUM', 'NYSE', 'Yum! Brands', 'Consumer Discretionary'),
('ZION', 'NASDAQ', 'Zions Bancorp', 'Financials'),
('ZMH', 'NYSE', 'Zimmer Holdings', 'Health Care');

-- --------------------------------------------------------

--
-- Table structure for table `wdgt_market_entity`
--

DROP TABLE IF EXISTS `wdgt_market_entity`;
CREATE TABLE IF NOT EXISTS `wdgt_market_entity` (
  `entity_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(4) DEFAULT NULL,
  `symbol` varchar(10) DEFAULT NULL,
  `exchange` varchar(10) DEFAULT NULL,
  `company_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`entity_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Table structure for table `wdgt_market_entity`
--
-- DROP TABLE IF EXISTS `wdgt_market_entity`;
-- INSERT INTO `wdgt_market_entity` (`entity_id`, `type`, `symbol`, `exchange`, `company_name`) VALUES
-- (40, 'EQTY', 'AMP', 'NYSE', 'Ameriprise Financial'),
-- (41, 'EQTY', 'BNI', 'NYSE', 'Burlington Northern Santa Fe'),
-- (42, 'EQTY', 'BMY', 'NYSE', 'Bristol Myers Squibb'),
-- (43, 'EQTY', '.DJI', 'INDEXDJX', 'Dow Jones Industrial Average'),
-- (44, 'EQTY', '.INX', 'INDEXSP', 'S&P 500'),
-- (45, 'EQTY', 'BEN', 'NYSE', 'Franklin Resources'),
-- (46, 'EQTY', 'AMZN', 'NASDAQ', 'Amazon.com'),
-- (47, 'EQTY', 'AEP', 'NYSE', 'American Electric Power');

-- --------------------------------------------------------

--
-- Table structure for table `wdgt_user`
--
DROP TABLE IF EXISTS `wdgt_user`;
CREATE TABLE IF NOT EXISTS `wdgt_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;




-- --------------------------------------------------------

--
-- Table structure for table `wdgt_user_ui`
--
DROP TABLE IF EXISTS `wdgt_user_ui`;
CREATE TABLE IF NOT EXISTS `wdgt_user_ui` (
  `user_ui_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `ui_id` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`user_ui_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=112 ;




-- --------------------------------------------------------

--
-- Table structure for table `wdgt_user_ui_market_entity`
--

CREATE TABLE IF NOT EXISTS `wdgt_user_ui_market_entity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_ui_id` bigint(20) DEFAULT NULL,
  `entity_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=56 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
