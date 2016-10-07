// Generated by Apple Swift version 2.1 (swiftlang-700.1.101.6 clang-700.1.76)
#pragma clang diagnostic push

#if defined(__has_include) && __has_include(<swift/objc-prologue.h>)
# include <swift/objc-prologue.h>
#endif

#pragma clang diagnostic ignored "-Wauto-import"
#include <objc/NSObject.h>
#include <stdint.h>
#include <stddef.h>
#include <stdbool.h>

#if defined(__has_include) && __has_include(<uchar.h>)
# include <uchar.h>
#elif !defined(__cplusplus) || __cplusplus < 201103L
typedef uint_least16_t char16_t;
typedef uint_least32_t char32_t;
#endif

typedef struct _NSZone NSZone;

#if !defined(SWIFT_PASTE)
# define SWIFT_PASTE_HELPER(x, y) x##y
# define SWIFT_PASTE(x, y) SWIFT_PASTE_HELPER(x, y)
#endif
#if !defined(SWIFT_METATYPE)
# define SWIFT_METATYPE(X) Class
#endif

#if defined(__has_attribute) && __has_attribute(objc_runtime_name)
# define SWIFT_RUNTIME_NAME(X) __attribute__((objc_runtime_name(X)))
#else
# define SWIFT_RUNTIME_NAME(X)
#endif
#if defined(__has_attribute) && __has_attribute(swift_name)
# define SWIFT_COMPILE_NAME(X) __attribute__((swift_name(X)))
#else
# define SWIFT_COMPILE_NAME(X)
#endif
#if !defined(SWIFT_CLASS_EXTRA)
# define SWIFT_CLASS_EXTRA
#endif
#if !defined(SWIFT_PROTOCOL_EXTRA)
# define SWIFT_PROTOCOL_EXTRA
#endif
#if !defined(SWIFT_ENUM_EXTRA)
# define SWIFT_ENUM_EXTRA
#endif
#if !defined(SWIFT_CLASS)
# if defined(__has_attribute) && __has_attribute(objc_subclassing_restricted) 
#  define SWIFT_CLASS(SWIFT_NAME) SWIFT_RUNTIME_NAME(SWIFT_NAME) __attribute__((objc_subclassing_restricted)) SWIFT_CLASS_EXTRA
#  define SWIFT_CLASS_NAMED(SWIFT_NAME) __attribute__((objc_subclassing_restricted)) SWIFT_COMPILE_NAME(SWIFT_NAME) SWIFT_CLASS_EXTRA
# else
#  define SWIFT_CLASS(SWIFT_NAME) SWIFT_RUNTIME_NAME(SWIFT_NAME) SWIFT_CLASS_EXTRA
#  define SWIFT_CLASS_NAMED(SWIFT_NAME) SWIFT_COMPILE_NAME(SWIFT_NAME) SWIFT_CLASS_EXTRA
# endif
#endif

#if !defined(SWIFT_PROTOCOL)
# define SWIFT_PROTOCOL(SWIFT_NAME) SWIFT_RUNTIME_NAME(SWIFT_NAME) SWIFT_PROTOCOL_EXTRA
# define SWIFT_PROTOCOL_NAMED(SWIFT_NAME) SWIFT_COMPILE_NAME(SWIFT_NAME) SWIFT_PROTOCOL_EXTRA
#endif

#if !defined(SWIFT_EXTENSION)
# define SWIFT_EXTENSION(M) SWIFT_PASTE(M##_Swift_, __LINE__)
#endif

#if !defined(OBJC_DESIGNATED_INITIALIZER)
# if defined(__has_attribute) && __has_attribute(objc_designated_initializer)
#  define OBJC_DESIGNATED_INITIALIZER __attribute__((objc_designated_initializer))
# else
#  define OBJC_DESIGNATED_INITIALIZER
# endif
#endif
#if !defined(SWIFT_ENUM)
# define SWIFT_ENUM(_type, _name) enum _name : _type _name; enum SWIFT_ENUM_EXTRA _name : _type
#endif
typedef float swift_float2  __attribute__((__ext_vector_type__(2)));
typedef float swift_float3  __attribute__((__ext_vector_type__(3)));
typedef float swift_float4  __attribute__((__ext_vector_type__(4)));
typedef double swift_double2  __attribute__((__ext_vector_type__(2)));
typedef double swift_double3  __attribute__((__ext_vector_type__(3)));
typedef double swift_double4  __attribute__((__ext_vector_type__(4)));
typedef int swift_int2  __attribute__((__ext_vector_type__(2)));
typedef int swift_int3  __attribute__((__ext_vector_type__(3)));
typedef int swift_int4  __attribute__((__ext_vector_type__(4)));
#if defined(__has_feature) && __has_feature(modules)
@import UIKit;
@import CoreGraphics;
#endif

#pragma clang diagnostic ignored "-Wproperty-attribute-mismatch"
#pragma clang diagnostic ignored "-Wduplicate-method-arg"
@class UIWindow;
@class UIApplication;
@class NSObject;
@class NSURL;
@class NSManagedObjectModel;
@class NSPersistentStoreCoordinator;
@class NSManagedObjectContext;

SWIFT_CLASS("_TtC11MyPDFReader11AppDelegate")
@interface AppDelegate : UIResponder <UIApplicationDelegate>
@property (nonatomic, strong) UIWindow * __nullable window;
- (BOOL)application:(UIApplication * __nonnull)application didFinishLaunchingWithOptions:(NSDictionary * __nullable)launchOptions;
- (void)applicationWillResignActive:(UIApplication * __nonnull)application;
- (void)applicationDidEnterBackground:(UIApplication * __nonnull)application;
- (void)applicationWillEnterForeground:(UIApplication * __nonnull)application;
- (void)applicationDidBecomeActive:(UIApplication * __nonnull)application;
- (void)applicationWillTerminate:(UIApplication * __nonnull)application;
@property (nonatomic, strong) NSURL * __nonnull applicationDocumentsDirectory;
@property (nonatomic, strong) NSManagedObjectModel * __nonnull managedObjectModel;
@property (nonatomic, strong) NSPersistentStoreCoordinator * __nullable persistentStoreCoordinator;
@property (nonatomic, strong) NSManagedObjectContext * __nullable managedObjectContext;
- (void)saveContext;
- (nonnull instancetype)init OBJC_DESIGNATED_INITIALIZER;
@end

@class UIWebView;
@class UIBarButtonItem;
@class UIPinchGestureRecognizer;
@class UISwipeGestureRecognizer;
@class NSBundle;
@class NSCoder;

SWIFT_CLASS("_TtC11MyPDFReader21DetailsViewController")
@interface DetailsViewController : UIViewController
@property (nonatomic, strong) IBOutlet UIWebView * __null_unspecified detailsWebView;
@property (nonatomic, strong) IBOutlet UIBarButtonItem * __null_unspecified previousPDFFileButton;
@property (nonatomic, strong) IBOutlet UIBarButtonItem * __null_unspecified nextPDFFileButton;
@property (nonatomic, copy) NSString * __nonnull fileName;
@property (nonatomic, copy) NSArray<NSString *> * __nonnull allPDFFiles;
@property (nonatomic) NSInteger indexOfPDF;
- (void)viewDidLoad;
- (void)displayPDFFile;
- (IBAction)previousPDFFileClicked:(UIBarButtonItem * __nonnull)sender;
- (IBAction)nextPDFFileClicked:(UIBarButtonItem * __nonnull)sender;
- (void)handlePinchGesture:(UIPinchGestureRecognizer * __nonnull)gesture;
- (void)handleSwipeGesture:(UISwipeGestureRecognizer * __nonnull)gesture;
- (void)didReceiveMemoryWarning;
- (nonnull instancetype)initWithNibName:(NSString * __nullable)nibNameOrNil bundle:(NSBundle * __nullable)nibBundleOrNil OBJC_DESIGNATED_INITIALIZER;
- (nullable instancetype)initWithCoder:(NSCoder * __nonnull)aDecoder OBJC_DESIGNATED_INITIALIZER;
@end

@class UISegmentedControl;

SWIFT_CLASS("_TtC11MyPDFReader18MainViewController")
@interface MainViewController : UIViewController
@property (nonatomic, readonly, copy) NSArray<NSString *> * __nonnull viewControllerIdentifiers;
@property (nonatomic, strong) IBOutlet UISegmentedControl * __null_unspecified segmentedControl;
- (void)viewDidLoad;
- (void)didReceiveMemoryWarning;
- (IBAction)indexChanged:(UISegmentedControl * __nonnull)sender;
- (IBAction)importPDFDocuments:(id __nonnull)sender;
- (nonnull instancetype)initWithNibName:(NSString * __nullable)nibNameOrNil bundle:(NSBundle * __nullable)nibBundleOrNil OBJC_DESIGNATED_INITIALIZER;
- (nullable instancetype)initWithCoder:(NSCoder * __nonnull)aDecoder OBJC_DESIGNATED_INITIALIZER;
@end

@class UIImageView;
@class UILabel;

SWIFT_CLASS("_TtC11MyPDFReader17PDFCollectionCell")
@interface PDFCollectionCell : UICollectionViewCell
@property (nonatomic, strong) IBOutlet UIImageView * __null_unspecified pdfImageView;
@property (nonatomic, strong) IBOutlet UILabel * __null_unspecified pdfLabel;
- (nonnull instancetype)initWithFrame:(CGRect)frame OBJC_DESIGNATED_INITIALIZER;
- (nullable instancetype)initWithCoder:(NSCoder * __nonnull)aDecoder OBJC_DESIGNATED_INITIALIZER;
@end

@class UICollectionView;
@class UISearchBar;
@class UIStoryboardSegue;
@class NSIndexPath;

SWIFT_CLASS("_TtC11MyPDFReader23PDFCollectionController")
@interface PDFCollectionController : UIViewController <UIBarPositioningDelegate, UICollectionViewDelegate, UIScrollViewDelegate, UICollectionViewDelegateFlowLayout, UISearchBarDelegate, UICollectionViewDataSource>
@property (nonatomic, strong) IBOutlet UICollectionView * __null_unspecified pdfCollectionView;
@property (nonatomic, strong) IBOutlet UISearchBar * __null_unspecified pdfSearchBar;
@property (nonatomic, copy) NSArray<NSString *> * __nonnull pdfFiles;
@property (nonatomic, copy) NSArray<NSString *> * __nonnull filteredPDFFiles;
@property (nonatomic) BOOL searchActive;
- (void)viewDidLoad;
- (void)prepareForSegue:(UIStoryboardSegue * __nonnull)segue sender:(id __nullable)sender;
- (void)didReceiveMemoryWarning;
- (NSInteger)numberOfSectionsInCollectionView:(UICollectionView * __nonnull)collectionView;
- (NSInteger)collectionView:(UICollectionView * __nonnull)collectionView numberOfItemsInSection:(NSInteger)section;
- (UICollectionViewCell * __nonnull)collectionView:(UICollectionView * __nonnull)collectionView cellForItemAtIndexPath:(NSIndexPath * __nonnull)indexPath;
- (void)searchBar:(UISearchBar * __nonnull)searchBar textDidChange:(NSString * __nonnull)searchText;
- (void)searchBarTextDidBeginEditing:(UISearchBar * __nonnull)searchBar;
- (void)searchBarTextDidEndEditing:(UISearchBar * __nonnull)searchBar;
- (void)searchBarSearchButtonClicked:(UISearchBar * __nonnull)searchBar;
- (void)searchBarCancelButtonClicked:(UISearchBar * __nonnull)searchBar;
- (nonnull instancetype)initWithNibName:(NSString * __nullable)nibNameOrNil bundle:(NSBundle * __nullable)nibBundleOrNil OBJC_DESIGNATED_INITIALIZER;
- (nullable instancetype)initWithCoder:(NSCoder * __nonnull)aDecoder OBJC_DESIGNATED_INITIALIZER;
@end

@class NSFileManager;
@class UITableView;
@class PDFViewCell;

SWIFT_CLASS("_TtC11MyPDFReader18PDFTableController")
@interface PDFTableController : UITableViewController <UIBarPositioningDelegate, UISearchBarDelegate>
@property (nonatomic, readonly, strong) NSFileManager * __nonnull fm;
@property (nonatomic, readonly, copy) NSString * __nonnull mainPath;
@property (nonatomic, copy) NSArray<NSString *> * __nonnull pdfFiles;
@property (nonatomic, copy) NSArray<NSString *> * __nonnull filteredPDFFiles;
@property (nonatomic) BOOL searchActive;
@property (nonatomic, strong) IBOutlet UITableView * __null_unspecified tvPDFs;
@property (nonatomic, strong) IBOutlet UISearchBar * __null_unspecified searchBar;
- (void)viewDidLoad;
- (void)prepareForSegue:(UIStoryboardSegue * __nonnull)segue sender:(id __nullable)sender;
- (IBAction)importPDFButton:(UIBarButtonItem * __nonnull)sender;
- (void)didReceiveMemoryWarning;
- (NSArray<NSString *> * __nonnull)listPDFFiles;
- (NSInteger)numberOfSectionsInTableView:(UITableView * __nonnull)tableView;
- (NSInteger)tableView:(UITableView * __nonnull)tableView numberOfRowsInSection:(NSInteger)section;
- (PDFViewCell * __nonnull)tableView:(UITableView * __nonnull)tableView cellForRowAtIndexPath:(NSIndexPath * __nonnull)indexPath;
- (void)searchBar:(UISearchBar * __nonnull)searchBar textDidChange:(NSString * __nonnull)searchText;
- (void)searchBarTextDidBeginEditing:(UISearchBar * __nonnull)searchBar;
- (void)searchBarTextDidEndEditing:(UISearchBar * __nonnull)searchBar;
- (void)searchBarSearchButtonClicked:(UISearchBar * __nonnull)searchBar;
- (void)searchBarCancelButtonClicked:(UISearchBar * __nonnull)searchBar;
- (nonnull instancetype)initWithStyle:(UITableViewStyle)style OBJC_DESIGNATED_INITIALIZER;
- (nonnull instancetype)initWithNibName:(NSString * __nullable)nibNameOrNil bundle:(NSBundle * __nullable)nibBundleOrNil OBJC_DESIGNATED_INITIALIZER;
- (nullable instancetype)initWithCoder:(NSCoder * __nonnull)aDecoder OBJC_DESIGNATED_INITIALIZER;
@end


SWIFT_CLASS("_TtC11MyPDFReader11PDFViewCell")
@interface PDFViewCell : UITableViewCell
@property (nonatomic, strong) IBOutlet UIImageView * __null_unspecified pdfThumbnailsImage;
@property (nonatomic, strong) IBOutlet UILabel * __null_unspecified pdfLabel;
- (void)awakeFromNib;
- (void)setSelected:(BOOL)selected animated:(BOOL)animated;
- (nonnull instancetype)initWithStyle:(UITableViewCellStyle)style reuseIdentifier:(NSString * __nullable)reuseIdentifier OBJC_DESIGNATED_INITIALIZER;
- (nullable instancetype)initWithCoder:(NSCoder * __nonnull)aDecoder OBJC_DESIGNATED_INITIALIZER;
@end


SWIFT_CLASS("_TtC11MyPDFReader14ViewController")
@interface ViewController : UIViewController
- (void)viewDidLoad;
- (void)didReceiveMemoryWarning;
- (nonnull instancetype)initWithNibName:(NSString * __nullable)nibNameOrNil bundle:(NSBundle * __nullable)nibBundleOrNil OBJC_DESIGNATED_INITIALIZER;
- (nullable instancetype)initWithCoder:(NSCoder * __nonnull)aDecoder OBJC_DESIGNATED_INITIALIZER;
@end

#pragma clang diagnostic pop